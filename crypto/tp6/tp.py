# ======
# Tp 6 :
# ======
print("----- Debut du tp -----")
print()

import sqlite3
connection = sqlite3.connect("donnees.db")
# curseur.execute("CREATE TABLE utilisateurs (name TEXT, password TEXT)")

print()
print("--- Exo 1 : ---")

def AfficherUtilisateurs(conn):
    print("Utilisateurs : ")
    print("- - - - - - - ")
    curseur = conn.cursor()
    curseur.execute("SELECT * FROM utilisateurs")
    
    utilisateurs = curseur.fetchall()
    for utilisateur in utilisateurs:
        print(utilisateur)


def AjoutUtilisateur(conn):
    login = input("Entrez son login : ")
    password = input("Entrez son mot de passe : ")
    password_confirm = input("Confirmez son mot de passe : ")
    
    if password != password_confirm:
        print("Les mots de passe ne correspondent pas.")
        return
    
    curseur = conn.cursor()
    curseur.execute("SELECT * FROM utilisateurs WHERE name=?", (login,))
    
    if curseur.fetchone():
        print("Ce login existe déjà.")
        return
    
    curseur.execute("INSERT INTO utilisateurs (name, password) VALUES (?, ?)", (login, password))
    conn.commit()
    print("Utilisateur ajouté avec succès.")


def Verification(conn):
    login = input("Login : ")
    password = input("Mot de passe : ")
    
    curseur = conn.cursor()
    curseur.execute("SELECT * FROM utilisateurs WHERE name=? AND password=?", (login, password))
    
    if curseur.fetchone():
        print("Authentification réussie.")
    else:
        print("Échec de l'authentification.")



# AfficherUtilisateurs(connection)
# AjoutUtilisateur(connection)
# AfficherUtilisateurs(connection)
# Verification(connection)

print()
print("--- Exo 2 : ---")

import hashlib

def hacher_mot_de_passe(mot_de_passe):
    hachage = hashlib.sha256(mot_de_passe.encode()).hexdigest()
    return hachage

def AjoutUtilisateur2(conn):
    login = input("Entrez son login : ")
    password = input("Entrez son mot de passe : ")
    password_confirm = input("Confirmez son mot de passe : ")
    
    if password != password_confirm:
        print("Les mots de passe ne correspondent pas.")
        return
    
    curseur = conn.cursor()
    curseur.execute("SELECT * FROM utilisateurs WHERE name=?", (login,))
    
    if curseur.fetchone():
        print("Ce login existe déjà.")
        return
    
    password_hashe = hacher_mot_de_passe(password)
    curseur.execute("INSERT INTO utilisateurs (name, password) VALUES (?, ?)", (login, password_hashe))
    conn.commit()
    print("Utilisateur ajouté avec succès.")


def Verification2(conn):
    login = input("Login : ")
    password = input("Mot de passe : ")
    password_hashe = hacher_mot_de_passe(password)
    
    curseur = conn.cursor()
    curseur.execute("SELECT * FROM utilisateurs WHERE name=? AND password=?", (login, password_hashe))
    
    if curseur.fetchone():
        print("Authentification réussie.")
    else:
        print("Échec de l'authentification.")


# AfficherUtilisateurs(connection)
# AjoutUtilisateur2(connection)
# AfficherUtilisateurs(connection)
# Verification2(connection)

print()
print("--- Exo 3 : ---")

# ----------------


connection.close()


