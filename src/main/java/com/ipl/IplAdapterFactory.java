package com.ipl;

import java.util.Map;

public class IplAdapterFactory {
    public static Map <String, IplSheetDAO> getCensusData( CricketLeagueAnalyser.IplSheet sheet,String... csvFilePath) throws CricketLeagueAnalyserException {
        if(sheet.equals(CricketLeagueAnalyser.IplSheet.WICKETSHEET))
            return new IplBolwersSheetCSVAdapter().loadIplSheetData( Ipl2019BowlersSheetCSV.class,csvFilePath);
        return new IplBatsmenSheetCSVAdapter().loadIplSheetData( Ipl2019BatsmenSheetCSV.class,csvFilePath);
    }
}
