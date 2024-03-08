require 'spec_helper'

describe 'Katas' do
  describe '#add' do
    it 'adds the two values' do
      expect(add(1, 2)).to eq 3
    end

    it 'adds negatives correctly' do
      expect(add(1, -1)).to eq 0
    end
  end

  describe '#cat' do
    it 'cats the two values' do
      expect(cat('Hello, ', 'world')).to eq 'Hello, world'
    end
  end

  describe '#words' do
    it 'returns the words' do
      expect(words('Je suis une patate')).to eq ['Je', 'suis', 'une', 'patate']
    end

    it 'correctly skips spaces the words' do
      expect(words('   Vous ne passerez        pas   ')).to eq [
        'Vous',
        'ne',
        'passerez',
        'pas'
      ]
    end
  end

  describe '#upcase!' do
    let(:string) { 'khaaan' }

    it 'returns true' do
      expect(upcase!(string)).to be true
    end

    it 'updates the string' do
      upcase!(string)
      expect(string).to eq 'KHAAAN'
    end
  end

  describe '#dot' do
    it 'returns the merged string by a dot' do
      expect(dot(['aut', 'eur', 'rice'])).to eq 'aut·eur·rice'
    end
  end

  describe '#minimum_length_4' do
    it 'returns the string with only words of min length 4' do
      expect(minimum_length_4('I do not like dwarves')).to eq 'like dwarves'
    end

    it 'can return an empty string if needed' do
      expect(minimum_length_4('And my axe')).to eq ''
    end
  end

  describe '#multiply_array' do
    it 'multiply the array by the second argument' do
      expect(multiply_array([1, 2, 3], 3)).to eq [3, 6, 9]
    end

    it 'works if the multiplier is negative' do
      expect(multiply_array([4, -2, 0], -2)).to eq [-8, 4, 0]
    end
  end

  describe '#sum' do
    it 'sums the numbers' do
      expect(sum([1, 2, 3])).to eq 6
    end

    it 'works with an empty array' do
      expect(sum([])).to eq 0
    end

    it 'works with negatives' do
      expect(sum([1, 2, -1, 3])).to eq 5
    end
  end

  describe '#capitalize_words' do
    it 'returns the string with the words capitalized' do
      expect(capitalize_words('Je ne connais pas la ponctuation'))
        .to eq 'Je Ne Connais Pas La Ponctuation'
    end
  end

  describe '#enumeration' do
    it 'returns the correct enumeration between 1 and n' do
      expect(enumeration(3)).to eq [1, 2, 3]
    end

    it 'works with negatives' do
      expect(enumeration(-1)).to eq [-1, 0, 1]
    end
  end

  describe '#compte_repetitions' do
    it 'returns the repetitions' do
      mots = [
        "oui", "bip", "bop", "bip", "blop", "oui", 
        "je", "suis", "un", "robot", "oui", "robot"
      ]

      expect(compte_repetitions(mots)).to eq({
        "bip" => 1,
        "blop" => 0,
        "bop" => 0,
        "je" => 0,
        "oui" => 2,
        "robot" => 1,
        "suis" => 0,
        "un" => 0,
      })
    end

    it 'supports an empty word list' do
      mots = []

      expect(compte_repetitions(mots)).to eq({})
    end
  end

  describe '#repetitions' do
    it 'returns the total count of repetitions' do
      s = 'Oui bip bop bip blop. Oui, je suis un robot, oui robot.'
      expect(repetitions(s)).to eq 4
    end

    it 'supports a string without repetitions' do
      s = 'hello world'
      expect(repetitions(s)).to eq 0
    end

    it 'supports an empty string' do
      s = ''
      expect(repetitions(s)).to eq 0
    end
  end

  describe '#dictionnary' do
    it 'turns a specific string into a dictionnary' do
      expect(dictionnary('Ours: Mammifère carnivore (ursidé)|Lapin: Mammifère rongeur très prolifique'))
        .to eq({
          'Ours' => 'Mammifère carnivore (ursidé)',
          'Lapin' => 'Mammifère rongeur très prolifique',
        })
    end
  end
end
