package fr.iut.tp2.data

import java.util.Calendar

object Stub {

    val conversations: List<Conversation> by lazy {
        createConversations()
    }

    val contacts: List<Contact> by lazy {
        conversations.map { it.contacts }.flatten().toSet().toList().shuffled()
    }

    private fun createConversations(): List<Conversation> {
        // Contacts
        val marie = Contact("Marie", true)
        val lucas = Contact("Lucas", false)
        val alexandre = Contact("Alexandre", true)
        val emma = Contact("Emma", true)
        val julie = Contact("Julie", true)
        val thomas = Contact("Thomas", false)
        val sophie = Contact("Sophie", true)
        val antoine = Contact("Antoine", false)
        val laura = Contact("Laura", true)

        return listOf(
            Conversation(
                1, "Soirée entre amis", listOf(marie, lucas), listOf(
                    Message(
                        "Salut tout le monde! Ça vous dirait une soirée ce samedi?",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 25, 17, 30) },
                        null,
                        true
                    ),
                    Message(
                        "Oh oui, bonne idée! Je suis partante.",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 25, 17, 45) },
                        marie,
                        true
                    ),
                    Message(
                        "Ça marche pour moi aussi. On fait quoi?",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 25, 18, 0) },
                        lucas,
                        true
                    ),
                    Message(
                        "Que pensez-vous d'un dîner chez moi suivi de jeux de société?",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 25, 18, 15) },
                        null,
                        true
                    ),
                    Message(
                        "Super idée! On apporte quoi?",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 25, 18, 30) },
                        marie,
                        true
                    ),
                    Message(
                        "Je peux prendre des boissons et des snacks.",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 25, 18, 45) },
                        lucas,
                        true
                    ),
                    Message(
                        "Parfait! Marie, tu peux peut-être ramener un dessert?",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 25, 19, 0) },
                        null,
                        true
                    ),
                    Message(
                        "Absolument! Je vais faire mon célèbre gâteau au chocolat.",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 25, 19, 15) },
                        marie,
                        false
                    ),
                    Message(
                        "Ça promet d'être une soirée géniale! J'ai hâte.",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 25, 19, 30) },
                        lucas,
                        false
                    )
                ).shuffled()
            ),
            Conversation(
                2, "Sortie en randonnée", listOf(alexandre, emma), listOf(
                    Message(
                        "Salut les amis! Le temps sera super ce weekend. Ça vous dit une randonnée samedi matin?",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 28, 10, 0) },
                        null,
                        true
                    ),
                    Message(
                        "Oh oui, ça fait longtemps que je n'ai pas fait de randonnée. Je suis partant!",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 28, 10, 15) },
                        alexandre,
                        true
                    ),
                    Message(
                        "Ça me tente bien aussi! On irait où?",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 28, 10, 30) },
                        emma,
                        true
                    ),
                    Message(
                        "Je pensais au sentier près du lac. C'est magnifique à cette période de l'année.",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 28, 10, 45) },
                        null,
                        true
                    ),
                    Message(
                        "Excellente idée! À quelle heure on se retrouve?",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 28, 11, 0) },
                        alexandre,
                        true
                    ),
                    Message(
                        "Disons à 9h00 au parking près de la piste.",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 28, 11, 15) },
                        null,
                        true
                    ),
                    Message(
                        "Parfait! Est-ce que je peux inviter mon cousin? Il adore la randonnée.",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 28, 11, 30) },
                        emma,
                        true
                    ),
                    Message(
                        "Bien sûr, plus on est de fous, plus on rit!",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 28, 11, 45) },
                        null,
                        true
                    ),
                    Message(
                        "Génial! J'ai hâte d'être samedi.",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 28, 12, 0) },
                        alexandre,
                        false
                    )
                ).shuffled()
            ),
            Conversation(
                3,
                "Marie",
                listOf(marie),
                listOf(
                    Message(
                        "Salut Marie, ça va?",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 25, 16, 0) },
                        null,
                        true
                    ),
                    Message(
                        "Salut! Oui, et toi?",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 25, 16, 5) },
                        marie,
                        true
                    ),
                    Message(
                        "Ça va bien aussi, merci!",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 25, 16, 10) },
                        null,
                        true
                    ),
                    Message(
                        "Tu as des projets pour demain?",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 26, 15, 0) },
                        null,
                        true
                    ),
                    Message(
                        "Non, rien de spécial. Pourquoi?",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 26, 15, 5) },
                        marie,
                        true
                    ),
                    Message(
                        "Je pensais peut-être à aller faire du shopping. Ça te dit de venir?",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 26, 15, 10) },
                        null,
                        true
                    )
                ).shuffled()
            ),
            Conversation(
                4,
                "Lucas",
                listOf(lucas),
                listOf(
                    Message(
                        "Salut Lucas, tu es libre ce weekend?",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 27, 10, 0) },
                        null,
                        true
                    ),
                    Message(
                        "Salut! Oui, pourquoi?",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 27, 10, 5) },
                        lucas,
                        true
                    ),
                    Message(
                        "Je pensais à organiser une sortie en randonnée.",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 27, 10, 10) },
                        null,
                        true
                    ),
                    Message(
                        "Ça me dit bien! Où et quand?",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 27, 10, 15) },
                        lucas,
                        true
                    ),
                    Message(
                        "Demain serait parfait, et peut-être vers 10h?",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 28, 9, 0) },
                        null,
                        true
                    ),
                    Message(
                        "Ça marche pour moi! On se retrouve là-bas.",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 28, 9, 5) },
                        lucas,
                        true
                    )
                ).shuffled()
            ),
            Conversation(
                5,
                "Alexandre",
                listOf(alexandre),
                listOf(
                    Message(
                        "Salut Alexandre, tu as déjà essayé ce nouveau restaurant?",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 22, 12, 0) },
                        null,
                        true
                    ),
                    Message(
                        "Non, mais j'en ai entendu parler. Ça a l'air sympa!",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 22, 12, 5) },
                        alexandre,
                        true
                    ),
                    Message(
                        "Tu veux y aller ce soir?",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 22, 12, 10) },
                        null,
                        true
                    ),
                    Message(
                        "Je suis partant! À quelle heure?",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 22, 12, 15) },
                        alexandre,
                        true
                    )
                ).shuffled()
            ), Conversation(
                6,
                "Emma",
                listOf(emma),
                listOf(
                    Message(
                        "Bonjour Emma, comment ça va?",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 20, 9, 0) },
                        null,
                        true
                    ),
                    Message(
                        "Bonjour! Je vais bien, merci. Et toi?",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 20, 9, 5) },
                        emma,
                        true
                    ),
                    Message(
                        "Je vais bien aussi, merci.",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 20, 9, 10) },
                        null,
                        true
                    )
                ).shuffled()
            ), Conversation(
                7,
                "Julie",
                listOf(julie),
                listOf(
                    Message(
                        "Salut Julie, tu as vu le match hier soir?",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 24, 11, 0) },
                        null,
                        true
                    ),
                    Message(
                        "Oui, c'était incroyable! Quelle victoire!",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 24, 11, 5) },
                        julie,
                        true
                    ),
                    Message(
                        "J'étais tellement nerveux pendant les prolongations!",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 24, 11, 10) },
                        null,
                        true
                    ),
                    Message(
                        "Moi aussi! Mais ça valait vraiment le coup.",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 24, 11, 15) },
                        julie,
                        true
                    )
                ).shuffled()
            ),
            Conversation(
                8,
                "Thomas",
                listOf(thomas),
                listOf(
                    Message(
                        "Salut Thomas, tu as des nouvelles?",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 20, 11, 0) },
                        null,
                        true
                    ),
                    Message(
                        "Salut! Rien de particulier, et toi?",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 20, 11, 5) },
                        thomas,
                        true
                    ),
                    Message(
                        "Pas grand-chose de mon côté non plus.",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 20, 11, 10) },
                        null,
                        true
                    )
                ).shuffled()
            ), Conversation(
                9,
                "Sophie",
                listOf(sophie),
                listOf(
                    Message(
                        "Salut Sophie, ça te dit d'aller au cinéma ce soir?",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 29, 18, 0) },
                        null,
                        true
                    ),
                    Message(
                        "Salut! Oui, super idée. Quel film?",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 29, 18, 5) },
                        sophie,
                        true
                    ),
                    Message(
                        "Il y a ce nouveau film d'action qui vient de sortir.",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 29, 18, 10) },
                        null,
                        true
                    )
                ).shuffled()
            ), Conversation(
                10,
                "Antoine",
                listOf(antoine),
                listOf(
                    Message(
                        "Salut Antoine, ça fait longtemps qu'on ne s'est pas parlé!",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 29, 14, 0) },
                        null,
                        true
                    ),
                    Message(
                        "Salut! Oui, c'est vrai. Comment vas-tu?",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 29, 14, 5) },
                        antoine,
                        true
                    ),
                    Message(
                        "Je vais bien, merci! On devrait se voir un de ces jours.",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 29, 14, 10) },
                        null,
                        true
                    )
                ).shuffled()
            ), Conversation(
                11,
                "Laura",
                listOf(laura),
                listOf(
                    Message(
                        "Coucou Laura, ça te dit de prendre un café ce soir?",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 28, 18, 0) },
                        null,
                        true
                    ),
                    Message(
                        "Salut! Oui, ce serait génial. Où et à quelle heure?",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 28, 18, 5) },
                        laura,
                        true
                    ),
                    Message(
                        "Que dirais-tu de chez Java Café à 19h?",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 28, 18, 10) },
                        null,
                        true
                    ),
                    Message(
                        "Parfait! À tout à l'heure!",
                        Calendar.getInstance().apply { set(2024, Calendar.FEBRUARY, 28, 18, 15) },
                        laura,
                        true
                    )
                ).shuffled()
            )
        ).shuffled()
    }
}