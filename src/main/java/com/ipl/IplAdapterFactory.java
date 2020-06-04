package com.ipl;

import java.util.Map;

public class IplAdapterFactory {
    public static Map <String, IplSheetDAO> getIPLData(CricketLeagueAnalyser.IplSheet sheet, String... csvFilePath) throws CricketLeagueAnalyserException {
        if(sheet.equals(CricketLeagueAnalyser.IplSheet.WICKETSHEET))
            return new IplBolwersSheetAdapter().loadIplSheetData( IplBowlersSheetCSV.class,csvFilePath);
        return new IplBatsmenSheetAdapter().loadIplSheetData( IplBatsmenSheetCSV.class,csvFilePath);

    }
}
