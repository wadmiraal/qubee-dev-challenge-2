package fr.sma.aoc.adventofcode2015.solution.day19;

import org.junit.jupiter.api.Test;

class Day19Ex2Test {

    @Test
    void run() {
        var input = "e => H\n" +
                "e => O\n" +
                "H => HO\n" +
                "H => OH\n" +
                "O => HH\n" +
                "\n" +
                "HOHOHO";
        Day19Ex2 solution = new Day19Ex2();
        System.out.println(solution.run(input));
    }

    @Test
    void run2() {
        var input = "Al => ThF\n" +
                "Al => ThRnFAr\n" +
                "B => BCa\n" +
                "B => TiB\n" +
                "B => TiRnFAr\n" +
                "Ca => CaCa\n" +
                "Ca => PB\n" +
                "Ca => PRnFAr\n" +
                "Ca => SiRnFYFAr\n" +
                "Ca => SiRnMgAr\n" +
                "Ca => SiTh\n" +
                "F => CaF\n" +
                "F => PMg\n" +
                "F => SiAl\n" +
                "H => CRnAlAr\n" +
                "H => CRnFYFYFAr\n" +
                "H => CRnFYMgAr\n" +
                "H => CRnMgYFAr\n" +
                "H => HCa\n" +
                "H => NRnFYFAr\n" +
                "H => NRnMgAr\n" +
                "H => NTh\n" +
                "H => OB\n" +
                "H => ORnFAr\n" +
                "Mg => BF\n" +
                "Mg => TiMg\n" +
                "N => CRnFAr\n" +
                "N => HSi\n" +
                "O => CRnFYFAr\n" +
                "O => CRnMgAr\n" +
                "O => HP\n" +
                "O => NRnFAr\n" +
                "O => OTi\n" +
                "P => CaP\n" +
                "P => PTi\n" +
                "P => SiRnFAr\n" +
                "Si => CaSi\n" +
                "Th => ThCa\n" +
                "Ti => BP\n" +
                "Ti => TiTi\n" +
                "e => HF\n" +
                "e => NAl\n" +
                "e => OMg\n" +
                "\n" +
                "CRnCaCaCaSiRnBPTiMgArSiRnSiRnMgArSiRnCaFArTiTiBSiThFYCaFArCaCaSiThCaPBSiThSiThCaCaPTiRnPBSiThRnFArArCaCaSiThCaSiThSiRnMgArCaPTiBPRnFArSiThCaSiRnFArBCaSiRnCaPRnFArPMgYCaFArCaPTiTiTiBPBSiThCaPTiBPBSiRnFArBPBSiRnCaFArBPRnSiRnFArRnSiRnBFArCaFArCaCaCaSiThSiThCaCaPBPTiTiRnFArCaPTiBSiAlArPBCaCaCaCaCaSiRnMgArCaSiThFArThCaSiThCaSiRnCaFYCaSiRnFYFArFArCaSiRnFYFArCaSiRnBPMgArSiThPRnFArCaSiRnFArTiRnSiRnFYFArCaSiRnBFArCaSiRnTiMgArSiThCaSiThCaFArPRnFArSiRnFArTiTiTiTiBCaCaSiRnCaCaFYFArSiThCaPTiBPTiBCaSiThSiRnMgArCaF";
        Day19Ex2 solution = new Day19Ex2();
        System.out.println(solution.run(input));
    }
}