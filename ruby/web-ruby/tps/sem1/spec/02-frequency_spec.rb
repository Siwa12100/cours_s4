require 'spec_helper'

describe 'Frequency' do
  describe '#clean_text' do
    let(:text) { "some«»text\.not,'\":;![really clean?]" }
    it 'cleans the text' do
      expect(clean_text(text)).to eq('some  text not       really clean  ')
    end
  end

  describe '#parse' do
    let(:text) { 'some  text not       really clean  ' }
    it 'splits the text' do
      expect(parse(text)).to eq(%w[some text not really clean])
    end
  end

  describe '#count_occurencies' do
    let(:words) { %w[some text not really clean and not really original] }
    it 'counts occurencies of each word' do
      expect(count_occurencies(words)).to eq(
        'some' => 1,
        'text' => 1,
        'not' => 2,
        'really' => 2,
        'clean' => 1,
        'and' => 1,
        'original' => 1
      )
    end
  end

  describe '#normalize' do
    let(:words) { %w[apple banana orange apple banana apple] }
    let(:occurencies) do
      {
        'apple' => 3,
        'banana' => 2,
        'orange' => 1
      }
    end

    it 'computes frequencies' do
      expect(normalize(occurencies, words.size)).to eq(
        'apple' => 0.5,
        'banana' => 0.333,
        'orange' => 0.167
      )
    end
  end

  describe '#display_top_20' do
    let(:frequencies) do
      {
        'layout' => 1,
        'post' => 1,
        'title' => 1,
        'tp1' => 2,
        'programmation' => 3,
        'objet' => 4,
        'interpr' => 2,
        'entr' => 2,
        'mati' => 2,
        'categories' => 1,
        'ruby' => 32,
        'pour' => 21,
        'but' => 2,
        'vous' => 20,
        'faire' => 2,
        'pratiquer' => 1,
        'les' => 26,
        'bases' => 3,
        'langage' => 5,
        'particulier' => 1,
        'prendre' => 2,
        'main' => 1,
        'que' => 12
      }
    end

    let(:expected_output) do
      <<OUTPUT
ruby: 32
les: 26
pour: 21
vous: 20
que: 12
langage: 5
objet: 4
programmation: 3
bases: 3
tp1: 2
interpr: 2
entr: 2
mati: 2
but: 2
faire: 2
prendre: 2
layout: 1
post: 1
title: 1
categories: 1
OUTPUT
    end

    it 'print the top 20 frequencies' do
      expect do
        display_top_20(frequencies)
      end.to output(expected_output).to_stdout
    end
  end
end
