package com.example.accnummvc.service;

//import com.example.accnumdatabase.entity.LabId;
//import com.example.accnumdatabase.repository.LabIdRepository;
import com.example.accnummvc.entity.LabId;
import com.example.accnummvc.repository.LabIdRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class LabIdServiceImpl implements LabIdService{
    private final LabIdRepository labIdRepository;


    public LabIdServiceImpl(LabIdRepository labIdRepository) {
        this.labIdRepository = labIdRepository;
    }

    public String accnum(LabId labId){

        String lastId = labIdRepository.findAllUsers();
        System.out.println(lastId);
        int initialValue=10000;
        LocalDate localDate=LocalDate.now();
        DateTimeFormatter localDate1 = DateTimeFormatter.ofPattern("yyyyMMdd");
        String dt= localDate.format(localDate1);

        System.out.println(lastId.substring(0,lastId.indexOf("-")));
        System.out.println(lastId.substring(lastId.indexOf("-")));


        if (!lastId.isEmpty() && lastId.substring(0,lastId.indexOf("-")).equals(dt)){
            initialValue = Integer.parseInt(lastId.substring(lastId.indexOf("-")+1));
        }


        initialValue++;
        String acc=dt+"-"+ initialValue;
        System.out.println(dt+"-"+ initialValue);
        labId.setValue(dt+"-"+ initialValue);

        return acc;
    }

    public String acc2(LabId labId){


//        labId.setValue(labIdRepository.findAllUsers());
        String a= labIdRepository.findAllUsers();
        String[] regx=a.split("-");
//        System.out.println(Integer.parseInt(regx[1])+1);
        LocalDate localDate=LocalDate.now();
        DateTimeFormatter localDate1 = DateTimeFormatter.ofPattern("yyyyMMdd");

        String dts= localDate.format(localDate1);
        String ss= regx[0];
        int num=Integer.parseInt(regx[1]);


        if(dts.equals(ss)){
            num=num+1;
            String acc=dts+"-"+ num;
//            labId.setValue(dts+"-"+ num);
            System.out.println("adsdsd");
            return  acc;

//            System.out.println(labId.getValue());
        }
        else{
            String acc=dts+"-"+ a;
          return  acc;
        }

//        StringBuffer bb= new StringBuffer(Arrays.toString(regx));
//        System.out.println(bb);
//        System.out.println(a);

//        return labIdRepository.findAllUsers();
    }

//    @Override
//    public LabId savealls(LabId labId) {
//        labId.setValue(accnum(labId));
//        return labIdRepository.save(labId);
//    }

//    @Override
//    public String getAllacc() {
////        LabId labId=new LabId();
////        acc2(labId);
//        return labIdRepository.findAllUsers();
//
//    }

    @Override
    public void saveAcc(LabId labId) {
        labId.setValue(accnum(labId));
        this.labIdRepository.save(labId);
    }
}
