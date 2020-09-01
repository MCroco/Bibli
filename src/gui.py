# Author : Mirica Constantin

# Importer tout ce dont on a besoin dans la création de l'interface
# importer la fonction prediction, qui est dans l'autre fichier
# elle sera utilisée afin de pouvoir utiliser les systémes
from predictions import *

# import pour pouvoir lire et écrire dans un fichier csv
import csv
from csv import writer, reader

# utile pour afficher la date d'aujoud'hui afin de pouvoir avoir une comparaison
# avec la date du dernier remplissage
from datetime import datetime

# est la bibliothèque graphique libre d'origine pour le langage Python
import tkinter
from tkinter import *

# pandas est nécessaires pour pour écrire et lire dans le fichier
# ça peut se faire aussi avec des url mais l'écriture et plus simple avec pandas
import pandas as pd

# utilisé afin de créer un compte à rebours
import time

import random

################  Fonction qui enregistre les données et vide le formulaire  ##########################
# cette fn sera appelée une fois que le bouton d'enregistrement est appuyé


def save_info():

    # Prendre les data du formulaire
    date_info = date_entry.get()
    date_info = str(date_info)

    remplissage_info = remplissage_entry.get()
    remplissage_info = str(remplissage_info)

    prix_info = prix_entry.get()
    prix_info = str(prix_info)

    capacite_info = capacite_entry.get()
    capacite_info = str(capacite_info)

    temperature_info = temperature_entry.get()
    temperature_info = str(temperature_info)

    produit_info = produit_entry.get()

    actif_info = actif_entry.get()
    actif_info = str(actif_info)

    """ Pendant les 4 lignes qui suivent, nous allons écrire - lire dans le fichier csv """
    # Create a dataframe from csv
    df = pd.read_csv('data.csv', delimiter=';')
    # User list comprehension to create a list of lists from Dataframe rows
    list_of_rows = [list(row) for row in df.values]
    # Insert Column names as first list in list of lists
    list_of_rows.insert(0, df.columns.to_list())

    # int(list_of_rows[-1][0])+1, produit_info, date_info, remplissage_info, prix_info, ' ',
    #actif_info, capacite_info, ' ', ' ', ' ',
    row_contents = [temperature_info]

    # fonction qui va ajouter les elements du formulaire au fichier csv

    def append_list_as_row(file_name, list_of_elem):
        # Open file in append mode
        with open(file_name, 'a+', newline='') as write_obj:
            # Create a writer object from csv module
            csv_writer = writer(write_obj)
            # Add contents of list as last row in the csv file
            csv_writer.writerow(list_of_elem)

    # appel de la fonction qui va ajouter les datas du form au csv
    append_list_as_row('data.csv', row_contents)

    # envoyer les predictions pour la dérniére lige de data / ce qu'on vient d'envoyer dans le form
    text1.insert(predic(Data[0-1]))
    # Vider le formulaire champ par champ
    date_entry.delete(0, END)
    remplissage_entry.delete(0, END)
    prix_entry.delete(0, END)
    produit_entry.delete(0, END)
    actif_entry.delete(0, END)
    capacite_entry.delete(0, END)
    temperature_entry.delete(0, END)


#############################  Fenêtre de l'application  ################################################
root = Tk()
root.geometry('900x590')
root.title("App Joassin")

############################   Ajouter client test  #####################################################


titre = Label(text="Client test")
titre.place(x=15, y=20)
titre.config(font=("Courier", 22))

# Les variables
date = StringVar()
remplissage = IntVar()
prix = IntVar()
capacite = IntVar()
temperature = IntVar()
produit = StringVar()
actif = IntVar()
citerne = IntVar()


# Les labels à afficher
date = Label(text="Date jj-mm-aa")
remplissage = Label(text="Remplissage maintenant")
prix = Label(text="Prix ")
capacite = Label(text="Capacité citerne ")
temperature = Label(text="Temperature ")
produit = Label(text="Produit ")
actif = Label(text="Actif ")


# Le placement des labels
date.place(x=15, y=70)
remplissage.place(x=15, y=120)
prix.place(x=15, y=170)
capacite.place(x=15, y=220)
temperature.place(x=15, y=270)
produit.place(x=15, y=320)
actif.place(x=15, y=370)


# Input des données
date_entry = Entry(textvariable=date, width="30")
remplissage_entry = Entry(textvariable=remplissage, width="30")
prix_entry = Entry(textvariable=prix, width="30")
capacite_entry = Entry(textvariable=capacite, width="30")
temperature_entry = Entry(textvariable=temperature, width="30")
produit_entry = Entry(textvariable=produit, width="30")
actif_entry = Entry(textvariable=actif, width="30")


# Placement des inputs des données
date_entry.place(x=15, y=90)
remplissage_entry.place(x=15, y=140)
prix_entry.place(x=15, y=190)
capacite_entry.place(x=15, y=240)
temperature_entry.place(x=15, y=290)
produit_entry.place(x=15, y=340)
actif_entry.place(x=15, y=390)


# Bouton pour enregistrer
register = Button(root, text="Enregistrer et lancer", width="27",
                  height="2", command=save_info, bg="White")
register.place(x=15, y=490)


# texte à afficher
text1 = tkinter.Text(root, height=25, width=70)
text1.pack(side=tkinter.LEFT)
text1.place(x=300, y=90)

##########################################################################################################
########################################   RUN APP  ######################################################

root.mainloop()
