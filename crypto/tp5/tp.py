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
        bloc = bits_encodes[i:i+7]
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



