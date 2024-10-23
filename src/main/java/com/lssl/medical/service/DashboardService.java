package com.lssl.medical.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.lssl.medical.dto.CompanyPolicyDTO;
import com.lssl.medical.dto.DoctorDTO;
import com.lssl.medical.dto.DrugDTO;
import com.lssl.medical.dto.TreatTypeDTO;
import com.lssl.medical.entity.DrugCompany;
import com.lssl.medical.entity.Material;
import com.lssl.medical.entity.Sale;
import com.lssl.medical.mapper.CompanyMapper;
import com.lssl.medical.mapper.DoctorMapper;
import com.lssl.medical.mapper.DrugMapper;
import com.lssl.medical.mapper.SaleMapper;
import com.lssl.medical.vo.DoctorVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author : 黑渊白花
 * @ClassName DashboardService
 * @date : 2024/10/23 20:11
 * @Description
 */
@Service
public class DashboardService {
    @Autowired
    DoctorMapper doctorMapper;
    @Autowired
    DrugMapper drugMapper;
    @Autowired
    CompanyMapper companyMapper;
    @Autowired
    SaleMapper saleMapper;
    @Autowired
    MaterialService materialService;
    @Autowired
    CompanyPolicyService companyPolicyService;
    public ObjectNode getDashboardData() {
        List<DoctorDTO> allDoctor = doctorMapper.getAllDoctor(new DoctorVo());
        //        获取控制面板药品、医师、药店和公司数量
        List<DrugDTO> allDrug = drugMapper.getAllDrug("");
        List<DrugCompany> allCompany = companyMapper.getAllCompany("");
        List<Sale> allSale = saleMapper.getAllSale("");
        int doctorNumb=allDoctor.size();
        int drugNumb=allDrug.size();
        int companyNumb=allCompany.size();
        int saleNumb=allSale.size();
//        获取每个doctor等级
        int docLevel1=0,docLevel2=0,docLevel3=0;
        List<TreatTypeDTO> allTreatType = doctorMapper.getAllTreatType();
        HashMap<String, Integer> treatMap = new HashMap<>();
//        构建Map获取所有的诊治类型
        for (TreatTypeDTO treat:allTreatType) {
            treatMap.put(treat.getName(),0);
        }
//        通过医生信息获取所有的医生级别和诊治类型医生数量
        for (DoctorDTO doc:allDoctor) {
            if (doc.getLevelId()==1){
                docLevel1++;
            }else if (doc.getLevelId()==2){
                docLevel2++;
            }if (doc.getLevelId()==3){
                docLevel3++;
            }
            treatMap.put(doc.getTreatType(),treatMap.get(doc.getTreatType())+1);
        };
        List<Material> allMaterial = materialService.getFirstMaterialWithPage();
        List<CompanyPolicyDTO> allPolicy = companyPolicyService.getFirstPolicyWithPage();
        ObjectMapper objectMapper = new ObjectMapper();

        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("doctorNumb",doctorNumb);
        objectNode.put("drugNumb",drugNumb);
        objectNode.put("companyNumb",companyNumb);
        objectNode.put("saleNumb",saleNumb);
        ObjectNode docLevelNode = objectMapper.createObjectNode();
        docLevelNode.put("l1",docLevel1);
        docLevelNode.put("l2",docLevel2);
        docLevelNode.put("l3",docLevel3);
        objectNode.put("docLevel",docLevelNode);
        JsonNode treatNode = objectMapper.convertValue(treatMap, JsonNode.class);
        objectNode.put("treatMap",treatNode);
        JsonNode materialNode = objectMapper.valueToTree(allMaterial);
        JsonNode policyNode = objectMapper.valueToTree(allPolicy);
        objectNode.put("materials",materialNode);
        objectNode.put("policys",policyNode);
        return objectNode;
    }



}
