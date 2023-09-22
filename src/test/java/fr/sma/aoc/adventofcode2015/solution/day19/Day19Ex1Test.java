package fr.sma.aoc.adventofcode2015.solution.day19;

import fr.sma.aoc.adventofcode2015.solution.day17.Day17Ex1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day19Ex1Test {

  @Test
  public void test1() {
    String input = """
      H => HO
      H => OH
      O => HH
      
      HOH""";


    String run = new Day19Ex1().run(input);
    assertEquals("4", run);
  }
  @Test
  public void test2() {
    String input = """
      Al => ThF
      Al => ThRnFAr
      B => BCa
      B => TiB
      B => TiRnFAr
      Ca => CaCa
      Ca => PB
      Ca => PRnFAr
      Ca => SiRnFYFAr
      Ca => SiRnMgAr
      Ca => SiTh
      F => CaF
      F => PMg
      F => SiAl
      H => CRnAlAr
      H => CRnFYFYFAr
      H => CRnFYMgAr
      H => CRnMgYFAr
      H => HCa
      H => NRnFYFAr
      H => NRnMgAr
      H => NTh
      H => OB
      H => ORnFAr
      Mg => BF
      Mg => TiMg
      N => CRnFAr
      N => HSi
      O => CRnFYFAr
      O => CRnMgAr
      O => HP
      O => NRnFAr
      O => OTi
      P => CaP
      P => PTi
      P => SiRnFAr
      Si => CaSi
      Th => ThCa
      Ti => BP
      Ti => TiTi
      e => HF
      e => NAl
      e => OMg
            
      CRnSiRnCaPTiMgYCaPTiRnFArSiThFArCaSiThSiThPBCaCaSiRnSiRnTiTiMgArPBCaPMgYPTiRnFArFArCaSiRnBPMgArPRnCaPTiRnFArCaSiThCaCaFArPBCaCaPTiTiRnFArCaSiRnSiAlYSiThRnFArArCaSiRnBFArCaCaSiRnSiThCaCaCaFYCaPTiBCaSiThCaSiThPMgArSiRnCaPBFYCaCaFArCaCaCaCaSiThCaSiRnPRnFArPBSiThPRnFArSiRnMgArCaFYFArCaSiRnSiAlArTiTiTiTiTiTiTiRnPMgArPTiTiTiBSiRnSiAlArTiTiRnPMgArCaFYBPBPTiRnSiRnMgArSiThCaFArCaSiThFArPRnFArCaSiRnTiBSiThSiRnSiAlYCaFArPRnFArSiThCaFArCaCaSiThCaCaCaSiRnPRnCaFArFYPMgArCaPBCaPBSiRnFYPBCaFArCaSiAl
      """;


    String run = new Day19Ex1().run(input);
    assertEquals("4", run);
  }

}
