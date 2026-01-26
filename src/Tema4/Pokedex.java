package Tema4;

import java.util.ArrayList;
import java.util.List;

public class Pokedex {
    
    public static List<Pokemon> getAllPokemon() {
        List<Pokemon> pokedex = new ArrayList<>();
        
        // Movimientos comunes
        Move placaje = new Move("Placaje", "Normal", "Fisico", 40, 100, 35, "NONE", 0);
        Move aranazo = new Move("Arañazo", "Normal", "Fisico", 40, 100, 35, "NONE", 0);
        Move gruñido = new Move("Gruñido", "Normal", "Estado", 0, 100, 40, "NONE", 0); // Simplificado
        Move latigo = new Move("Látigo", "Normal", "Estado", 0, 100, 30, "NONE", 0); // Simplificado
        
        // Movimientos Elementales Básicos
        Move ascuas = new Move("Ascuas", "Fuego", "Especial", 40, 100, 25, "BRN", 0.1);
        Move pistolaAgua = new Move("Pistola Agua", "Agua", "Especial", 40, 100, 25, "NONE", 0);
        Move latigoCepa = new Move("Látigo Cepa", "Planta", "Fisico", 45, 100, 25, "NONE", 0);
        Move impactrueno = new Move("Impactrueno", "Electrico", "Especial", 40, 100, 30, "PAR", 0.1);
        
        // Movimientos Avanzados
        Move lanzallamas = new Move("Lanzallamas", "Fuego", "Especial", 90, 100, 15, "BRN", 0.1);
        Move hidrobomba = new Move("Hidrobomba", "Agua", "Especial", 110, 80, 5, "NONE", 0);
        Move rayoSolar = new Move("Rayo Solar", "Planta", "Especial", 120, 100, 10, "NONE", 0); // Simplificado sin carga
        Move rayo = new Move("Rayo", "Electrico", "Especial", 90, 100, 15, "PAR", 0.1);
        Move terremoto = new Move("Terremoto", "Tierra", "Fisico", 100, 100, 10, "NONE", 0);
        Move psiquico = new Move("Psíquico", "Psiquico", "Especial", 90, 100, 10, "NONE", 0);
        Move avalancha = new Move("Avalancha", "Roca", "Fisico", 75, 90, 10, "NONE", 0); // Sin flinch
        Move ventisca = new Move("Ventisca", "Hielo", "Especial", 110, 70, 5, "FRZ", 0.1);
        Move hiperrayo = new Move("Hiperrayo", "Normal", "Especial", 150, 90, 5, "NONE", 0); // Sin turno de recarga
        
        // Movimientos de Estado
        Move ondaTrueno = new Move("Onda Trueno", "Electrico", "Estado", 0, 90, 20, "PAR", 1.0);
        Move toxico = new Move("Tóxico", "Veneno", "Estado", 0, 90, 10, "PSN", 1.0);
        Move hipnosis = new Move("Hipnosis", "Psiquico", "Estado", 0, 60, 20, "SLP", 1.0);
        Move recuperacion = new Move("Recuperación", "Normal", "Estado", 0, 100, 10, "HEAL", 1.0);
        Move proteccion = new Move("Protección", "Normal", "Estado", 0, 100, 10, "PROTECT", 1.0);

        // --- KANTO STARTERS & EVOLUTIONS ---
        
        // Bulbasaur Line
        Pokemon bulbasaur = new Pokemon("Bulbasaur", "Planta", "Veneno", 45, 49, 49, 65, 65, 45);
        bulbasaur.addMoveToPool(placaje); bulbasaur.addMoveToPool(gruñido); bulbasaur.addMoveToPool(latigoCepa); bulbasaur.addMoveToPool(toxico);
        pokedex.add(bulbasaur);
        
        Pokemon ivysaur = new Pokemon("Ivysaur", "Planta", "Veneno", 60, 62, 63, 80, 80, 60);
        ivysaur.addMoveToPool(placaje); ivysaur.addMoveToPool(latigoCepa); ivysaur.addMoveToPool(toxico); ivysaur.addMoveToPool(rayoSolar);
        pokedex.add(ivysaur);

        Pokemon venusaur = new Pokemon("Venusaur", "Planta", "Veneno", 80, 82, 83, 100, 100, 80);
        venusaur.addMoveToPool(terremoto); venusaur.addMoveToPool(latigoCepa); venusaur.addMoveToPool(toxico); venusaur.addMoveToPool(rayoSolar);
        pokedex.add(venusaur);

        // Charmander Line
        Pokemon charmander = new Pokemon("Charmander", "Fuego", null, 39, 52, 43, 60, 50, 65);
        charmander.addMoveToPool(aranazo); charmander.addMoveToPool(gruñido); charmander.addMoveToPool(ascuas); charmander.addMoveToPool(lanzallamas);
        pokedex.add(charmander);

        Pokemon charmeleon = new Pokemon("Charmeleon", "Fuego", null, 58, 64, 58, 80, 65, 80);
        charmeleon.addMoveToPool(aranazo); charmeleon.addMoveToPool(ascuas); charmeleon.addMoveToPool(lanzallamas); charmeleon.addMoveToPool(proteccion);
        pokedex.add(charmeleon);

        Pokemon charizard = new Pokemon("Charizard", "Fuego", "Volador", 78, 84, 78, 109, 85, 100);
        charizard.addMoveToPool(lanzallamas); charizard.addMoveToPool(terremoto); charizard.addMoveToPool(hiperrayo); charizard.addMoveToPool(proteccion);
        pokedex.add(charizard);

        // Squirtle Line
        Pokemon squirtle = new Pokemon("Squirtle", "Agua", null, 44, 48, 65, 50, 64, 43);
        squirtle.addMoveToPool(placaje); squirtle.addMoveToPool(latigo); squirtle.addMoveToPool(pistolaAgua); squirtle.addMoveToPool(proteccion);
        pokedex.add(squirtle);

        Pokemon wartortle = new Pokemon("Wartortle", "Agua", null, 59, 63, 80, 65, 80, 58);
        wartortle.addMoveToPool(placaje); wartortle.addMoveToPool(pistolaAgua); wartortle.addMoveToPool(hidrobomba); wartortle.addMoveToPool(proteccion);
        pokedex.add(wartortle);

        Pokemon blastoise = new Pokemon("Blastoise", "Agua", null, 79, 83, 100, 85, 105, 78);
        blastoise.addMoveToPool(hidrobomba); blastoise.addMoveToPool(terremoto); blastoise.addMoveToPool(ventisca); blastoise.addMoveToPool(proteccion);
        pokedex.add(blastoise);

        // --- OTROS POKEMON POPULARES (Muestra representativa de los 151) ---
        
        // Pikachu Line
        Pokemon pikachu = new Pokemon("Pikachu", "Electrico", null, 35, 55, 40, 50, 50, 90);
        pikachu.addMoveToPool(impactrueno); pikachu.addMoveToPool(ondaTrueno); pikachu.addMoveToPool(rayo); pikachu.addMoveToPool(placaje);
        pokedex.add(pikachu);

        Pokemon raichu = new Pokemon("Raichu", "Electrico", null, 60, 90, 55, 90, 80, 110);
        raichu.addMoveToPool(rayo); raichu.addMoveToPool(ondaTrueno); raichu.addMoveToPool(hiperrayo); raichu.addMoveToPool(proteccion);
        pokedex.add(raichu);

        // Pidgey Line
        Pokemon pidgey = new Pokemon("Pidgey", "Normal", "Volador", 40, 45, 40, 35, 35, 56);
        pidgey.addMoveToPool(placaje); pidgey.addMoveToPool(aranazo);
        pokedex.add(pidgey);
        
        Pokemon pidgeot = new Pokemon("Pidgeot", "Normal", "Volador", 83, 80, 75, 70, 70, 101);
        pidgeot.addMoveToPool(hiperrayo); pidgeot.addMoveToPool(placaje); pidgeot.addMoveToPool(proteccion);
        pokedex.add(pidgeot);

        // Mewtwo
        Pokemon mewtwo = new Pokemon("Mewtwo", "Psiquico", null, 106, 110, 90, 154, 90, 130);
        mewtwo.addMoveToPool(psiquico); mewtwo.addMoveToPool(recuperacion); mewtwo.addMoveToPool(rayo); mewtwo.addMoveToPool(ventisca);
        pokedex.add(mewtwo);
        
        // Snorlax
        Pokemon snorlax = new Pokemon("Snorlax", "Normal", null, 160, 110, 65, 65, 110, 30);
        snorlax.addMoveToPool(hiperrayo); snorlax.addMoveToPool(terremoto); snorlax.addMoveToPool(recuperacion); snorlax.addMoveToPool(proteccion);
        pokedex.add(snorlax);
        
        // Gengar
        Pokemon gengar = new Pokemon("Gengar", "Fantasma", "Veneno", 60, 65, 60, 130, 75, 110);
        gengar.addMoveToPool(hipnosis); gengar.addMoveToPool(psiquico); gengar.addMoveToPool(rayo); gengar.addMoveToPool(toxico);
        pokedex.add(gengar);
        
        // Gyarados
        Pokemon gyarados = new Pokemon("Gyarados", "Agua", "Volador", 95, 125, 79, 60, 100, 81);
        gyarados.addMoveToPool(hidrobomba); gyarados.addMoveToPool(hiperrayo); gyarados.addMoveToPool(terremoto); gyarados.addMoveToPool(ventisca);
        pokedex.add(gyarados);
        
        // Dragonite
        Pokemon dragonite = new Pokemon("Dragonite", "Dragon", "Volador", 91, 134, 95, 100, 100, 80);
        dragonite.addMoveToPool(hiperrayo); dragonite.addMoveToPool(rayo); dragonite.addMoveToPool(ventisca); dragonite.addMoveToPool(terremoto);
        pokedex.add(dragonite);

        // Inicializar movimientos por defecto para todos
        for (Pokemon p : pokedex) {
            p.setDefaultMoves();
        }

        return pokedex;
    }
    
    public static Pokemon getPokemonByName(String name) {
        List<Pokemon> all = getAllPokemon();
        for (Pokemon p : all) {
            if (p.getName().equalsIgnoreCase(name)) {
                // Devolver una COPIA nueva del Pokemon para que cada jugador tenga su instancia
                return clonePokemon(p);
            }
        }
        return null;
    }
    
    // Método helper para clonar un Pokemon base y que sea una instancia única en combate
    private static Pokemon clonePokemon(Pokemon base) {
        Pokemon clone = new Pokemon(base.getName(), base.getType1(), base.getType2(), 
                                    (base.getHpMax() - 110) / 2, // Revertir calculo HP para constructor
                                    base.getAttack(), base.getDefense(), 
                                    base.getSpAttack(), base.getSpDefense(), base.getSpeed());
        
        // Copiar movepool
        for (Move m : base.getMovePool()) {
            clone.addMoveToPool(m);
        }
        clone.setDefaultMoves();
        return clone;
    }
}
