#!/usr/bin/env ruby

def clean_text(text)
end

def parse(text)
end

def count_occurencies(words)
end

def normalize(occurencies, total_count)
end

def display_top_20(frequencies)
end

# Le code suivant s'execute uniquement lorsque ce fichier est le fichier
# principal en cours d'exécution (et non si il est requis ou chargé
# par un autre fichier)
if $0 == __FILE__
  if ARGV.empty?
    puts 'usage: frequency.rb <text_file>'
    exit 0
  end

  file_path = ARGV[0]

  # Lecture du fichier texte
  file_content = File.read(file_path)

  # Nettoyage du texte (pour la ponctuation par exemple
  cleaned_text = clean_text(file_content)

  # Séparation du texte en mots
  words = parse(cleaned_text)

  # Comptage des occurences des mots
  occurencies = count_occurencies(words)

  # Calcul des fréquences (normalisation des occurences)
  frequencies = normalize(occurencies, words.size)

  # Tri et affichage des 20 premiers résultats
  display_top_20(frequencies)
end
