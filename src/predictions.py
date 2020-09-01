# Author : Mirica Constantin

# Les 2 imports suivants sont similaires
# mais les datas de sortie sont sous des formats
# différents.

# pour travailler avec le fichier CSV
import csv
# pour travailler avec le fichier CSV
import urllib

# utilisé pour gérer les informations sortie du csv
import numpy


# librarie pour le ML avec les algorithmes nécessaires
from sklearn import svm
from sklearn import linear_model
from sklearn import tree
from sklearn.metrics import *
from sklearn.neural_network import MLPClassifier

# des outils pour le ML
from sklearn import preprocessing

# utilisé pour voir les différents avancements gràce aux graphiques
import matplotlib.pyplot as plt

import os

# fn pour trouver la val la plus grande


def high(t, X):
    return max(X[:-t])

# fn pour trouver la val la plus petite


def low(t, X):
    return min(X[:-t])


def extract_features(data):

    data = data[:, [0, 1, 2, 3, 5, 6, 7, 8]]
    features = data[:-1, :] - data[1:, :]
    PrixHigh = high(12, data[:, 1])  # highest prix
    PrixLow = low(12, data[:, 2])  # lowest prix
    rhigh = high(12, data[:, 3])  # highest remplissage
    rlow = low(12, data[:, 4])  # lowest remplissage
    PTempH = high(12, data[:, 5])  # Highest temperature
    PTempL = low(12, data[:, 6])  # lowest temperature
    PCiterne = high(12, data[:, 7])  # Highest citerne
    PCiterne = low(12, data[:, 8])  # lowest citerne

    price_diff_by_highlow = features[:, 0] / float(PrixHigh - PrixLow)
    temp_diff_by_high_low = features[:, 3]/float(PTempH - PTempL)
    capacit_diff_by_high_low = features[:, 2]/float(rhigh - rlow)
    refill_diff_by_high_low = features[:, 4]/float(rhigh - rlow)
    mov_avg_by_data = list()

    # trouver les "clients parfaits"
    for i in range(len(features)):
        mov_avg_by_data.append(numpy.mean(data[:i+1, :], axis=0)/data[i, :])

    mov_avg_by_data = numpy.array(mov_avg_by_data)

    features = data[:-1, [0]] - data[1:, [0]]
    # Normalisation des data  - standardiser les données  - impératif pour le ML
    features = preprocessing.normalize(features, norm='4')

    if data.shape[1] == 7:
        j_f = data[:, [6]]
        j_f = j_f[1:]
        j_f = numpy.array(j_f)
        # transformer le array d"une dimension, dans un de 2D
        features = numpy.column_stack(
            (features, price_diff_by_highlow, temp_diff_by_high_low, mov_avg_by_data, capacit_diff_by_high_low, j_f))
    else:
        features = numpy.column_stack(
            (features, price_diff_by_highlow, temp_diff_by_high_low, capacit_diff_by_high_low, mov_avg_by_data))

    return features

# Fn pour avancer jour par jour


def move_days_forward(data, days):
    labels = ((data[days:, 3] - data[days:, 0]) > 0).astype(int)
    data = data[:-days, :]
    return data, labels


def predict(data):
    Accuracy_scores = list()
    data = numpy.array(data)
    data = data.astype(float)
    Volume = data[:, 5]
    #
    labels = ((data[:, 3] - data[:, 0]) > 0).astype(int)

    # bouger jour par jour aprés le le remplissage
    data, labels = move_days_forward(data, 1)
    # la valeur de la capacité d'ajhd dépends de celle de hier
    features = extract_features(data)

    # 6500 - équivalent de 25% de données que j'ai en ma posséssion
    train_features = features[6500:]
    test_features = features[:6500]

    train_labels = labels[6500:-1]
    test_labels = labels[:6500]

    # valeur utilisée pour pour le SVM
    # C = cout de l'erreur de classification - à quel point on tient compte
    C_Val = [10e-1, 10e0, 10e1, 10e2]
    # C =  gama défini le niveau de précision. S'il est trop grand, les exigences sont trop
    # importantes et des cas potentiellement ok sont éliminés
    Gamma_Val = [10e-2, 10e-1, 10e0, 10e1]

    ################################ Neural Net #################################
    """
    Solver
    Utilisé pour optimiser le poids des néurones.
    Pour des "petits" ensemble de données, ‘lbfgs’ 
    peut calculer plus vite la bonne distribution des poids, 
    donc l'application ira mieux.

    Activation
    La fonction d'activation d'un des noeuds, en foction de leur poids

    Alpha
    Paramétre de 'tuning'; il s'occupe des réglages précis de la la couche 2 cachée
    """
    clf = MLPClassifier(solver='lbfgs', activation='relu', alpha=1e-5,
                        hidden_layer_sizes=(3, 2, 7), max_iter=200, random_state=1)
    clf.fit(train_features, train_labels)

    predicted = clf.predict(test_features)
    Accuracy = accuracy_score(test_labels, predicted)
    Accuracy_scores.append(Accuracy)

    step = numpy.arange(0, len(test_labels))
    plt.subplot(211)
    plt.xlim(-1, len(test_labels) + 1)
    plt.ylim(-1, 2)
    plt.ylabel('Actual Values')
    plt.plot(step, test_labels, drawstyle='step')
    plt.subplot(212)
    plt.xlim(-1, len(test_labels) + 1)
    plt.ylim(-1, 2)
    plt.xlabel('Days')
    plt.ylabel('Predicted Values')
    plt.plot(step, predicted, drawstyle='step')
    plt.show()


"""
Juste le MPL reste en execution donc les autres algos vont être mis de côté
Normalement ils doivent être mis en commentaire, mais ici je les laisse ainsi
pour plus de visibilité. C'est pour cela que certaines vars ne sont pas "définies", 
car elles le sont au sein de la fn "predict".
"""

#################### SVM-RBF KERNEL ############################
max_acc = 0
max_c = 0
max_g = 0
for c in C_Val:
    for g in Gamma_Val:
        clf = svm.SVC(kernel='rbf', C=c, gamma=g).fit(
            train_features, train_labels)
        curr_acc = accuracy_score(test_labels, clf.predict(test_features))
        if curr_acc > max_acc:
            max_acc = curr_acc
            max_g = g
            max_c = c

clf = svm.SVC(kernel='rbf', C=max_c, gamma=max_g).fit(
    train_features, train_labels)
best_predicted = clf.predict(test_features)
best_acc = accuracy_score(test_labels, best_predicted)
Accuracy_scores.append(best_acc)


# A été utilisé pour afficher les graphiques, afin de pouvoir comparer le 'tuning'
step = numpy.arange(0, len(test_labels))
plt.subplot(211)
plt.xlim(-1, len(test_labels) + 1)
plt.ylim(-1, 2)
plt.ylabel('Actual Values')
plt.plot(step, test_labels, drawstyle='step')
plt.subplot(212)
plt.xlim(-1, len(test_labels) + 1)
plt.ylim(-1, 2)
plt.xlabel('Days')
plt.ylabel('Predicted Values')
plt.plot(step, best_predicted, drawstyle='step')
plt.show()


########################### Decision Trees #############################
clf = tree.DecisionTreeClassifier(
    min_samples_split=80, min_impurity_split=1e-5)
clf.fit(train_features, train_labels)

predicted = clf.predict(test_features)
Accuracy = accuracy_score(test_labels, predicted)
# print "Decision tree Accuracy: ", Accuracy
Accuracy_scores.append(Accuracy)

step = numpy.arange(0, len(test_labels))
plt.subplot(211)
plt.xlim(-1, len(test_labels) + 1)
plt.ylim(-1, 2)
plt.ylabel('Actual Values')
plt.plot(step, test_labels, drawstyle='step')
plt.subplot(212)
plt.xlim(-1, len(test_labels) + 1)
plt.ylim(-1, 2)
plt.xlabel('Days')
plt.ylabel('Predicted Values')
plt.plot(step, best_predicted, drawstyle='step')
plt.show()

################################ Logistic Regression #################################
max_acc = 0
max_c = 0
max_g = 0
C_Val = [10e-7]
for c in C_Val:
    clf = linear_model.LogisticRegression(
        C=c).fit(train_features, train_labels)
    curr_acc = accuracy_score(test_labels, clf.predict(test_features))
    if curr_acc > max_acc:
        max_acc = curr_acc
        max_c = c

clf = linear_model.LogisticRegression(
    C=max_c).fit(train_features, train_labels)
best_predicted = clf.predict(test_features)
best_accuracy = accuracy_score(test_labels, best_predicted)


Accuracy_scores.append(best_accuracy)

step = numpy.arange(0, len(test_labels))
plt.subplot(211)
plt.xlim(-1, len(test_labels) + 1)
plt.ylim(-1, 2)
plt.ylabel('Actual Values')
plt.plot(step, test_labels, drawstyle='step')
plt.subplot(212)
plt.xlim(-1, len(test_labels) + 1)
plt.ylim(-1, 2)
plt.xlabel('Days')
plt.ylabel('Predicted Values')
plt.plot(step, best_predicted, drawstyle='step')
plt.show()
return Accuracy_scores


############ C'est ici qu'on lit le fichier et que  je cherche les données du CSV ###############

# Indiquer le path du fichier
urls = ['data.csv']
script_dir = os.path.dirname(__file__)


Net_Accuracy = list()
for url in urls:
    url = os.path.join(script_dir, url)
    data = list()

    # lescture des datas
    with open(url, 'r') as f:
        reader = csv.reader(f)
        for row in reader:
            data.append(row)
    # ajouter les datas dans un array afin de pouvoir travailler avec
    data = numpy.array(data)
    data = data[1:, 1:]

    # ajouter les  data de fiabilité au fichier csv
    Net_Accuracy.append(predict(data))

algos = ["SVM-RBF", "Decision Trees", "MLP", "Logistic-Regression"]
Net_Accuracy = numpy.array(Net_Accuracy)
Net_Accuracy = numpy.mean(Net_Accuracy, axis=0)
# vider les data de fiabilité pour pouvoir en créer d'autres
Net_Accuracy.__delattr__

################### C'est ici que les algos stockent leurs prédictions sur les stocks des clients######
stocks = [Share('Data')]
Net_Accuracy = list()
for stock in stocks:
    data = list()
    for attr in stock.get_historical('1/01/19', '16/01/20'):
        row = list()
        row.append(attr['Open'])
        row.append(attr['High'])
        row.append(attr['Low'])
        row.append(attr['Close'])
        row.append(attr['Volume'])
        row.append(attr['Close'])
        data.append(row)

    Net_Accuracy.append(predict(data))
algos = ["SVM-RBF", "Decision Trees", "MLP", "Logistic-Regression"]
Net_Accuracy = numpy.array(Net_Accuracy)
Net_Accuracy = numpy.mean(Net_Accuracy, axis=0)
