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
                    CricketLeagueAnalyserException.ExceptionType.FILE_NOT_PRESENT);

        }catch(CSVBuilderException e){
            throw new CricketLeagueAnalyserException(e.getMessage(),
                    CricketLeagueAnalyserException.ExceptionType.NOT_ABLE_TO_PARSE);
        }catch(RuntimeException e){
            throw new CricketLeagueAnalyserException(e.getMessage(),
                    CricketLeagueAnalyserException.ExceptionType.DATA_NOT_APPROPRIATE);
        }
    }

    public String getAverageWiseSortedData() throws CricketLeagueAnalyserException {
        Comparator<IplRunSheetDAO> iplCSVComparator =Comparator.comparing(sortBy->sortBy.average);
        return sort(iplCSVComparator);
    }

    public String getStrikeRateWiseSortedData() throws CricketLeagueAnalyserException {
        Comparator<IplRunSheetDAO> iplCSVComparator =Comparator.comparing(sortBy->sortBy.strikeRate);
        return sort(iplCSVComparator);
    }

    public String getSixesWiseSortedData() throws CricketLeagueAnalyserException {
        Comparator<IplRunSheetDAO> iplCSVComparator =Comparator.comparing(sortBy->sortBy.sixes);
        return sort(iplCSVComparator);
    }

    public String getFoursWiseSortedData() throws CricketLeagueAnalyserException {
        Comparator<IplRunSheetDAO> iplCSVComparator =Comparator.comparing(sortBy->sortBy.fours);
        return sort(iplCSVComparator);
    }

    public String sort(Comparator cricketLeagueCSV) throws CricketLeagueAnalyserException {
        if(runSheetMap==null || runSheetMap.size()==0){
            throw new CricketLeagueAnalyserException("No League Data",
                    CricketLeagueAnalyserException.ExceptionType.DATA_NOT_APPROPRIATE);
        }
        List sortedDataByColumn= (List) runSheetMap.values().stream().
                sorted(cricketLeagueCSV).collect(Collectors.toList());
        String sortedDataInJson=new Gson().toJson(sortedDataByColumn);
        return sortedDataInJson;
    }


    public String getStrikeRateWiseWithSixesAndFoursSortedData() throws CricketLeagueAnalyserException {
        Comparator<IplRunSheetDAO> iplCSVCompareByStrikeRate =Comparator.comparing(sortBy->sortBy.strikeRate);
        Comparator<IplRunSheetDAO> iplCSVCompareBySixes=iplCSVCompareByStrikeRate.thenComparing(sortBy->sortBy.sixes);
        Comparator<IplRunSheetDAO> iplCSVCompareByFours=iplCSVCompareBySixes.thenComparing(sortBy->sortBy.fours);
        return sort(iplCSVCompareByFours);
    }
}
