package com.ipl;

import com.opencsv.bean.CsvBindByName;

public class Ipl2019BatsmenSheetCSV {
    @CsvBindByName(column ="PLAYER" , required=true)
    public String player;

    @CsvBindByName(column ="Mat")
    public int match;

    @CsvBindByName(column ="Inns")
    public int innings;

    @CsvBindByName(column ="NO")
    public int notOut;

    @CsvBindByName(column ="Runs" , required=true)
    public int runs;

    @CsvBindByName(column ="SR" )
    public double strikeRate;

    @CsvBindByName(column ="Avg" )
    public double average;

    @CsvBindByName(column = "Wkts")
    public int wickets;

    @CsvBindByName(column ="100" )
    public int hundreds;

    @CsvBindByName(column ="50")
    public int fiftys;

    @CsvBindByName(column ="6s" , required=true)
    public int sixes;

    @CsvBindByName(column ="4s" , required=true)
    public int fours;

    public Ipl2019BatsmenSheetCSV() {
    }

    public Ipl2019BatsmenSheetCSV(String player, int match,
                                  int innings, int notOut,
                                  int runs, double strikeRate,
                                  double average, int hundreds,
                                  int fiftys, int sixes, int fours) {
        this.player = player;
        this.match = match;
        this.innings = innings;
        this.notOut = notOut;
        this.runs = runs;
        this.strikeRate = strikeRate;
        this.average = average;
        this.hundreds = hundreds;
        this.fiftys = fiftys;
        this.sixes = sixes;
        this.fours = fours;
    }

    @Override
    public String toString() {
        return "Ipl2019RunsSheet{" +
                "player='" + player + '\'' +
                ", match=" + match +
                ", innings=" + innings +
                ", notOut=" + notOut +
                ", runs=" + runs +
                ", strikeRate=" + strikeRate +
                ", average=" + average +
                ", hundreds=" + hundreds +
                ", fiftys=" + fiftys +
                ", sixes=" + sixes +
                ", fours=" + fours +
                '}';
    }
}
