<?php

class Employe implements \JsonSerializable{

    protected int $id;
    protected String $nom;  
    protected int $age;

    public function __construct(int $id, String $nom) {
        $this -> id = $id;
        $this -> nom = $nom;
        $this -> age = 67;
    }

    public function jsonSerialize() {
        return [
            'id' => $this->id,
            'nom' => $this->nom
        ];
    }
}
