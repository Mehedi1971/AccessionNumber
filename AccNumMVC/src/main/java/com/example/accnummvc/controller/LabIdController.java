package com.example.accnummvc.controller;

//import com.example.accnumdatabase.entity.LabId;
//import com.example.accnumdatabase.repository.LabIdRepository;
//import com.example.accnumdatabase.service.LabIdService;
import com.example.accnummvc.entity.LabId;
import com.example.accnummvc.repository.LabIdRepository;
import com.example.accnummvc.service.LabIdService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Controller
public class LabIdController {

    private final LabIdService labIdService;
    private final LabIdRepository labIdRepository;

    public LabIdController(LabIdService labIdService, LabIdRepository labIdRepository) {
        this.labIdService = labIdService;
        this.labIdRepository = labIdRepository;
    }

    @GetMapping("/sampleacc")
    public String saveAcc(@ModelAttribute("LabId") LabId labId,Model model) {
        labIdService.saveAcc(labId);
        System.out.println(labId);

        model.addAttribute("lastlabId", labId);
        System.out.println(labId);
        return "acc";
    }











//    @PostMapping("/")
//    public LabId saveall(@RequestBody LabId labId){
//        LocalDate localDate=LocalDate.now();
//        DateTimeFormatter localDate1 = DateTimeFormatter.ofPattern("yyyyMMdd");
//
////        String dt=localDate.getYear()+""+localDate.getMonthValue()+""+localDate.getDayOfMonth();
//        String dt= localDate.format(localDate1);
//        int a=10003;
//        System.out.println(dt+"-"+ a);
//        labId.setValue(dt+"-"+ a);
//        return labIdRepository.save(labId);
////        return "redirect:/";
//
//    }

    @GetMapping("/")
    private String getAll(){
        System.out.println(labIdRepository.findAllUsers());
        LabId labId=new LabId();
        labId.setValue(labIdRepository.findAllUsers());
        String a= labId.getValue();
        String[] regx=a.split("-");
        System.out.println(Integer.parseInt(regx[1])+1);
        LocalDate localDate=LocalDate.now();
        DateTimeFormatter localDate1 = DateTimeFormatter.ofPattern("yyyyMMdd");

// String dt=localDate.getYear()+""+localDate.getMonthValue()+""+localDate.getDayOfMonth();
        String dts= localDate.format(localDate1);
        String ss= regx[0];
// LocalDate date1=new SimpleDateFormat("yyyyMMdd").parse(ss);
        int num=Integer.parseInt(regx[1]);


        if(dts.equals(ss)){
            num=num+1;
            labId.setValue(dts+"-"+ num);
//            return labIdRepository.save(labId);
            System.out.println("adsdsd");
            System.out.println(labId.getValue());
        }
        else{
            labId.setValue(dts+"-"+ num);
        }
// for(int i=0;i<regx.length;i++){
// System.out.println(regx[i]);
// }
        StringBuffer bb= new StringBuffer(Arrays.toString(regx));
        System.out.println(bb);
        System.out.println(a);

        return labIdRepository.findAllUsers();
    }

//    @PostMapping("/")
//    public LabId saveall(@RequestBody LabId labId){
//        LocalDate localDate=LocalDate.now();
//        String dt=localDate.getYear()+""+localDate.getMonthValue()+""+localDate.getDayOfMonth();
//        int a=10000;
//        System.out.println(dt+""+ a);
//        labId.setValue(dt+"-"+ a);
//       return labIdRepository.save(labId);
////        return "redirect:/";
//
//    }
//@GetMapping("/")
//    public List<LabId> getall(){
//        return  labIdRepository.findAll();
//}




//    @PostMapping("/{year}/{month}")
//    public ResponseEntity<Integer> getNextSequenceValue(@PathVariable Integer year, @PathVariable Integer month )
//    {
//        LabId labId = labIdRepository.findById(new Integer[] {year, month}) .orElseGet(() ->
//    {
//        LabId newSequenceValue = new LabId(); newSequenceValue.setYear(year); newSequenceValue.setMonth(month);
//        newSequenceValue.setValue(0); return labIdRepository.save(newSequenceValue);
//    }
//    );
//        Integer currentValue = labId.getValue(); labId.setValue(currentValue + 1);
//        labIdRepository.save(labId); return ResponseEntity.ok(currentValue + 1);
//    }

}

