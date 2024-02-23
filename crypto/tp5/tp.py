# ============
# Exercice 1 :
# ============
print()
print("------ Exo 1 -------")


def decode_ascii(binary_string):
    bytes_liste = [binary_string[i:i+8] for i in range(0, len(binary_string), 8)]
    decimal_liste = [int(byte, 2) for byte in bytes_liste]

    ascii_characteres = [chr(decimal) for decimal in decimal_liste]
    decode_string = ''.join(ascii_characteres)

    return decode_string

message = "01000011011011110110110101101101011001010110111001100011" \
                  "01100101011110100010000001110000011000010111001000100000" \
                  "01100011011000010111001101110011011001010111001000100000" \
                  "01101100011001010111001100100000011000110110111101110100" \
                  "01100101011100110010000001100100011001010010000001100011" \
                  "01100101001000000110100001100001011000110110101101100101" \
                  "01110010001000000111000001101111011101010111001000100000" \
                  "01101111011000100111010001100101011011100110100101110010" \
                  "00100000011001000110010101110011001000000110100101101110" \
                  "01100110011011110111001001101101011000010111010001101001" \
                  "01101111011011100111001100101110"

message_decode = decode_ascii(message)
print("Message decodé  : ", message_decode)


# ============
# Exercice 2 :
# ============
print()
print(" ------- Exo 2 -------")

def extraire_bits_information(bits_encodes):
    bits_information = ""
    for i in range(0, len(bits_encodes), 7):
        bits_information += bits_encodes[i:i+4]
    return bits_information


def decodage_hamming(bits_encodes):
    bits_corriges = ""
    for i in range(0, len(bits_encodes), 7):
        # Assurez-vous que la taille du bloc est correcte
        bloc = bits_encodes[i:i+7]
        if len(bloc) != 7:
            break

        controle_parite = [int(bloc[4]) ^ int(bloc[0]) ^ int(bloc[1]) ^ int(bloc[2]),
                            int(bloc[5]) ^ int(bloc[0]) ^ int(bloc[1]) ^ int(bloc[3]),
                            int(bloc[6]) ^ int(bloc[1]) ^ int(bloc[2]) ^ int(bloc[3])]

        position_erreur = sum([2**i for i, bit in enumerate(controle_parite) if bit == 1])

        if position_erreur != 0:
            bloc_corrigé = list(bloc)
            bloc_corrigé[position_erreur - 1] = str(1 - int(bloc_corrigé[position_erreur - 1]))
            bits_corriges += "".join(bloc_corrigé)[:4]
        else:
            bits_corriges += bloc[:4]

    return bits_corriges


msg = "01001110011110011001011111110110010110101001100101101010" \
      "01100100101100011001011101000110010001111001100100101100" \
      "01110011010011001010100000000111001000000001100100001011" \
      "01110010010101001010100000000110010001111001100100001011" \
      "01110010011110011100100111100110010010110001110010010101" \
      "00101010000000011001011000010110010010110001110010011110" \
      "00101010000000011001000111100110010111111101110100100111" \
      "01100100101100011100100111100010101000000001100100100111" \
      "01100100101100001010100000000110010001111001100100101100" \
      "00101010000000011001010001100110010000101101100100011110" \
      "01100101011000011001001011000111001001010100101010000000" \
      "01110010000000011001011111110111001010110001110010010101" \
      "00101010000000011001011111110110010001010101110010100111" \
      "01100100101100011001011101000110010100110101110010010101" \
      "00101010000000011001001001110110010010110001110010011110" \
      "00101010000000011001010011010110010111010001100100110010" \
      "01100101111111011100100101010110010110101001100100001011" \
      "01110010100111011001010011010110010111111101100101110100" \
      "0111001001111000101011110100"

print(extraire_bits_information(msg))
print()
print(decodage_hamming(extraire_bits_information(msg)))


# ============
# Exercice 3 :
# ============
print()
print(" ------- Exo 3 -------")

def encodage_ascii(chaine):
    bits_resultats = ""

    for caractere in chaine:

        code_ascii = ord(caractere)
        bits_caractere = bin(code_ascii)[2:]
        bits_caractere = '0' * (8 - len(bits_caractere)) + bits_caractere
        bits_resultats += bits_caractere
    
    return bits_resultats

chaine_test = "Hello"
resultat = encodage_ascii(chaine_test)
print(resultat)


# ============
# Exercice 4 :
# ============
print()
print(" ------- Exo 4 -------")


def encodage_hamming_7_4(bits):
    bits_encodes = ""
    for i in range(0, len(bits), 4):
        bloc = bits[i:i+4]
        if len(bloc) != 4:
            break

        bits_encodes += bloc[0] + bloc[1] + bloc[2] + bloc[0] + bloc[3] + bloc[1] + bloc[2] + bloc[3]

        parite1 = str(int(bloc[0]) ^ int(bloc[1]) ^ int(bloc[2]))
        parite2 = str(int(bloc[1]) ^ int(bloc[2]) ^ int(bloc[3]))
        parite3 = str(int(bloc[0]) ^ int(bloc[1]) ^ int(bloc[3]))

        bits_encodes += parite1 + parite2 + parite3

    return bits_encodes

resultat_encodage = encodage_hamming_7_4(resultat)
print(resultat_encodage)


#=============
# Exercice 5 :
# ============