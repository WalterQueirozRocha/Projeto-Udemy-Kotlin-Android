package com.example.projeto2udemy.data

import com.example.projeto2udemy.MotivationConstants
import kotlin.random.Random

class Phrase(val description: String, val category: Int, val language: String)

class Mock {

    private val all = MotivationConstants.FILTER.ALL
    private val sun = MotivationConstants.FILTER.SUN
    private val moon = MotivationConstants.FILTER.MOON
    private val langEn = MotivationConstants.LANGUAGE.ENG
    private val langPt = MotivationConstants.LANGUAGE.PT
    private val langFr = MotivationConstants.LANGUAGE.FR

    private val listPhrases: List<Phrase> = listOf(
        Phrase("Não sabendo que era impossível, foi lá e fez.", sun, langPt),
        Phrase(
            "Você não é derrotado quando perde, você é derrotado quando desiste!",
            sun,
            langPt
        ),
        Phrase("Quando está mais escuro, vemos mais estrelas!", sun, langPt),
        Phrase(
            "Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.",
            sun,
            langPt
        ),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", sun, langPt),
        Phrase(
            "O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?",
            sun,
            langPt
        ),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", moon, langPt),
        Phrase("Você perde todas as chances que você não aproveita.", moon, langPt),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", moon, langPt),
        Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", moon, langPt),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", moon, langPt),
        Phrase("Se você acredita, faz toda a diferença.", moon, langPt),
        Phrase(
            "Riscos devem ser corridos, porque o maior perigo é não arriscar nada!",
            moon,
            langPt
        ),
        Phrase("Not knowing it was impossible, he went there and did it.", sun, langEn),
        Phrase(
            "You are not defeated when you lose, you are defeated when you give up!",
            sun,
            langEn
        ),
        Phrase("When it's darker, we see more stars!", sun, langEn),
        Phrase(
            "Insanity is always doing the same thing and expecting a different result.",
            sun,
            langEn
        ),
        Phrase("Don't stop when you're tired, stop when you're done.", sun, langEn),
        Phrase("What can you do now that has the biggest impact on your success?", sun, langEn),
        Phrase("The best way to predict the future is to invent it.", moon, langEn),
        Phrase("You lose every chance you don't take.", moon, langEn),
        Phrase("Failure is the spice that flavors success.", moon, langEn),
        Phrase(" As long as we are not committed, there will be hesitation!", moon, langEn),
        Phrase("If you don't know where you want to go, any way will do.", moon, langEn),
        Phrase("If you believe, it makes all the difference.", moon, langEn),
        Phrase(
            "Risks must be taken, because the greatest danger is not risking anything!",
            moon,
            langEn
        ),
        Phrase("Ne sachant pas que c'était impossible, il y est allé et l'a fait.", sun, langFr),
        Phrase(
            "Tu n'es pas vaincu quand tu perds, tu es vaincu quand tu abandonnes!",
            sun,
            langFr
        ),
        Phrase("Quand il fait plus sombre, on voit plus d'étoiles!", sun, langFr),
        Phrase(
            "La folie, c'est toujours faire la même chose et s'attendre à un résultat différent.",
            sun,
            langFr
        ),
        Phrase("Ne t'arrête pas quand tu es fatigué, arrête quand tu as fini.", sun, langFr),
        Phrase(
            "Que pouvez-vous faire maintenant qui a le plus grand impact sur votre succès?",
            sun,
            langFr
        ),
        Phrase("La meilleure façon de prédire l'avenir est de l'inventer.", moon, langFr),
        Phrase("Vous perdez toutes les chances que vous ne prenez pas.", moon, langFr),
        Phrase("L'échec est l'épice qui parfume le succès.", moon, langFr),
        Phrase("Tant qu'on n'est pas engagé, il y aura des hésitations!", moon, langFr),
        Phrase(
            "Si vous ne savez pas où vous voulez aller, n'importe quoi fera l'affaire.",
            moon,
            langFr
        ),
        Phrase("Si vous croyez, cela fait toute la différence.", moon, langFr),
        Phrase(
            "Il faut prendre des risques, car le plus grand danger est de ne rien risquer!",
            moon,
            langFr
        )
    )

    fun getPhrase(value: Int, language: String): String {
        var langFilter = language.lowercase()
        if (language !in listOf(langEn, langPt, langFr)) {
            langFilter = langPt
        }

        val filtered = listPhrases.filter {
            (it.category == value || value == all) && (it.language == langFilter)
        }

        val rand = Random.nextInt(filtered.size)
        return filtered[rand].description
    }

}