package com.ipl;

import com.IndianCensus.CSVBuilderException;
import com.IndianCensus.ICSVBuilder;
import com.IndianCensus.CSVBuilderFactory;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class CricketLeagueAnalyser {
    Map<String, IplRunSheetDAO> runSheetMap=null;
    public CricketLeagueAnalyser(){
        runSheetMap=new HashMap<String, IplRunSheetDAO>();
    }
    public  int loadRunsSheetData(String csvFilePath) throws CricketLeagueAnalyserException {
        try(Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder icsvBuilder = CSVBuilderFactory.createCSVBuilder();
          Iterator<Ipl2019RunsSheetCSV> csvIterator=icsvBuilder.getCSVFileIterator(reader, Ipl2019RunsSheetCSV.class);
          Iterable<Ipl2019RunsSheetCSV> csvIterable=()->csvIterator;
            StreamSupport.stream(csvIterable.spliterator(),false)
                    .forEach(iplRunsCSV -> runSheetMap.put(iplRunsCSV.player,new IplRunSheetDAO(iplRunsCSV)));
           return runSheetMap.size();
        }catch(IOException e){
            throw new CricketLeagueAnalyserException("problem with CSV file",
                    CricketLeagueAnalyserException.ExceptionType.CSV_FILE_PROBLEM);

        }catch(CSVBuilderException e){
            throw new CricketLeagueAnalyserException(e.getMessage(),
                    CricketLeagueAnalyserException.ExceptionType.NOT_ABLE_TO_PARSE);
        }
    }

    public String getAverageWiseSortedData() throws CricketLeagueAnalyserException {
        if(runSheetMap==null || runSheetMap.size()==0){
            throw new CricketLeagueAnalyserException("No League Data",
                    CricketLeagueAnalyserException.ExceptionType.DATA_NOT_APPROPRIATE);
        }
        Comparator<IplRunSheetDAO> iplCSVComparator =Comparator.comparing(average->average.average);
        List sortedDataByAverage=runSheetMap.values().stream().
                sorted(iplCSVComparator).collect(Collectors.toList());
        String sortedAverageDataInJson=new Gson().toJson(sortedDataByAverage);
        return sortedAverageDataInJson;
    }
}
