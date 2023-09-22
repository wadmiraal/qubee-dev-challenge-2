package fr.sma.aoc.adventofcode2015.solution.day21;

import fr.sma.aoc.adventofcode2015.ExSolution;
import fr.sma.aoc.adventofcode2015.ResolveApplication;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.stereotype.Component;

@Component
public class Day21Ex1 implements ExSolution {

  public static void main(String[] args) {
    ResolveApplication.main(new String[]{"21", "1"});
  }

  @Override
  public String run(String input) {


    Item Dagger = new Item(8, 4, 0);
    Item Shortsword = new Item(10, 5, 0);
    Item Warhammer = new Item(25, 6, 0);
    Item Longsword = new Item(40, 7, 0);
    Item Greataxe = new Item(74, 8, 0);
    List<Item> weapons = List.of(Dagger, Shortsword, Warhammer, Longsword, Greataxe);

    Item Empty = new Item(0, 0, 0);
    Item Leather = new Item(13, 0, 1);
    Item Chainmail = new Item(31, 0, 2);
    Item Splintmail = new Item(53, 0, 3);
    Item Bandedmail = new Item(75, 0, 4);
    Item Platemail = new Item(102, 0, 5);
    List<Item> armors = List.of(Empty, Leather, Chainmail, Splintmail, Bandedmail, Platemail);

    Item RingEmpty1 = new Item(0, 0, 0);
    Item RingEmpty2 = new Item(0, 0, 0);
    Item Damage1 = new Item(25, 1, 0);
    Item Damage2 = new Item(50, 2, 0);
    Item Damage3 = new Item(100, 3, 0);
    Item Defense1 = new Item(20, 0, 1);
    Item Defense2 = new Item(40, 0, 2);
    Item Defense3 = new Item(80, 0, 3);
    List<Item> rings = List.of(RingEmpty1, RingEmpty2, Damage1, Damage2, Damage3, Defense1, Defense2, Defense3);


    Map<Set<Item>, Integer> costByStuff = new HashMap<>();
    for (Item weapon : weapons) {
      for (Item armor : armors) {
        for (Item ring1 : rings) {
          for (Item ring2 : rings) {
            if (ring2 == ring1) {
              continue;
            }
            int cost = weapon.cost + armor.cost + ring1.cost + ring2.cost;
            costByStuff.put(Set.of(weapon, armor, ring1, ring2), cost);
          }
        }
      }
    }

    int min = Integer.MAX_VALUE;

    for (Map.Entry<Set<Item>, Integer> entry : costByStuff.entrySet()) {
      Set<Item> items = entry.getKey();
      int damage = items.stream().mapToInt(a -> a.damage).sum();
      int armor = items.stream().mapToInt(a -> a.armor).sum();

      Stats player = new Stats(100, damage, armor);
      Stats boss = new Stats(104, 8, 1);

      while (player.hitpoint > 0 && boss.hitpoint > 0) {
        boss.hitpoint -= Math.max(1, player.damage - boss.armor);
        if (boss.hitpoint <= 0) {
          break;
        }
        player.hitpoint -= Math.max(1, boss.damage - player.armor);
      }

      if (boss.hitpoint <= 0) {
        //System.out.println("win cost " + entry.getValue());
        min = Math.min(min,entry.getValue());
      } else {
        //System.out.println("boss won");
      }

      //System.out.println(player);
      //System.out.println(boss);

    }

    return ""+min;
  }


  public class Stats {
    int hitpoint;
    int damage;
    int armor;

    public Stats(int hitpoint, int damage, int armor) {
      this.hitpoint = hitpoint;
      this.damage = damage;
      this.armor = armor;
    }

    @Override
    public String toString() {
      return "Stats{" +
        "hitpoint=" + hitpoint +
        ", damage=" + damage +
        ", armor=" + armor +
        '}';
    }
  }

  public class Item {
    int cost;
    int damage;
    int armor;

    public Item(int cost, int damage, int armor) {
      this.cost = cost;
      this.damage = damage;
      this.armor = armor;
    }
  }

}
