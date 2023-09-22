package fr.sma.aoc.adventofcode2015.solution.day22;

import fr.sma.aoc.adventofcode2015.ExSolution;
import fr.sma.aoc.adventofcode2015.ResolveApplication;
import java.util.function.Consumer;
import org.springframework.stereotype.Component;

@Component
public class Day22Ex1 implements ExSolution {

  public static void main(String[] args) {
    ResolveApplication.main(new String[]{"22", "1"});
  }

  public static int bossDamage = 9;

  public static int minManaWin = Integer.MAX_VALUE;

  @Override
  public String run(String input) {

    State state = new State(58, 50, 500, 0, 0, 0, 0);



    return "";
  }

  public static void play(State state) {
    // apply effect at start of any turn
    state = applyAllEffects(state);
    if(checkDone(state)){
      return;
    }

    // execute player turn

    // choose
    State state1 = play(state, State::castMagicMissile);
    State state2 = play(state, State::castDrain);
    State state3 = play(state, State::castShield);
    State state4 = play(state, State::castPoison);
    State state5 = play(state, State::castRecharge);

    if(checkDone(state)){
      return;
    }

    // Boss turn
    state = applyAllEffects(state);
    if(checkDone(state)){
      return;
    }

    state = state.applyBossTurn();
    if(checkDone(state)){
      return;
    }

    play(state);

  }

  private static boolean checkDone(State state) {
    if (state.bossHitpoint <= 0) {
      // player won
      if (state.manaSpent < minManaWin) {
        minManaWin = state.manaSpent;
      }
      return true;
    }
    if (state.playerHitpoint <= 0) {
      // boss won
      return true;
    }
    if(state.manaSpent > minManaWin){
      // less good than best, stop here
      return true;
    }
    return false;
  }

  private static State applyAllEffects(State start) {
    start = start.applyRecharge();
    start = start.applyPoison();
    start = start.applyShieldEffect();
    return start;
  }

  public record State(int bossHitpoint,
                      int playerHitpoint, int mana, int manaSpent,
                      int turnShield, int turnPoison, int turnRecharge) {

    public State castMagicMissile() {
      return new State(bossHitpoint - 4, playerHitpoint, mana - 53, manaSpent + 53, turnShield, turnPoison, turnRecharge);
    }

    public State castDrain() {
      return new State(bossHitpoint - 2, playerHitpoint + 2, mana - 73, manaSpent + 73, turnShield, turnPoison, turnRecharge);
    }

    public State castPoison() {
      return new State(bossHitpoint, playerHitpoint, mana - 173, manaSpent + 173, turnShield, 6, turnRecharge);
    }

    public State applyRecharge() {
      if (turnRecharge > 0) {
        return new State(bossHitpoint, playerHitpoint, mana + 101, manaSpent, turnShield, turnPoison, turnRecharge - 1);
      } else {
        return this;
      }
    }

    public State applyPoison() {
      if (turnPoison > 0) {
        return new State(bossHitpoint - 3, playerHitpoint, mana, manaSpent, turnShield, turnPoison - 1, turnRecharge);
      } else {
        return this;
      }
    }

    public State applyShieldEffect() {
      if (turnShield > 0) {
        return new State(bossHitpoint, playerHitpoint, mana, manaSpent, turnShield - 1, turnPoison, turnRecharge);
      } else {
        return this;
      }
    }

    public State applyBossTurn() {
      int armor = turnShield > 0 ? 7 : 0;
      return new State(bossHitpoint, playerHitpoint - Math.max(1, bossDamage - armor), mana, manaSpent, turnShield, turnPoison,
        turnRecharge);
    }

    public State castShield() {
      if (turnShield > 0) {
        return this;
      } else {
        return new State(bossHitpoint, playerHitpoint, mana - 113, manaSpent + 113, 6, turnPoison, turnRecharge);
      }
    }

    public State castRecharge() {
      if (turnRecharge > 0) {
        return this;
      } else {
        return new State(bossHitpoint, playerHitpoint, mana - 229, manaSpent + 229, turnShield, turnPoison, 5);
      }
    }
  }

}
