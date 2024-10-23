package com.lssl.medical.controller;

import com.github.pagehelper.PageInfo;
import com.lssl.medical.bean.Msg;
import com.lssl.medical.dto.DrugDTO;
import com.lssl.medical.service.DrugService;
import com.lssl.medical.vo.DrugVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.Date;

/**
 * @author : 黑渊白花
 * @ClassName DrugController
 * @date : 2024/10/23 19:23
 * @Description
 */

@Api(tags = "药品控制器类")
@RestController
@RequestMapping("/api/drugs")
@CrossOrigin
public class DrugController {
    @Autowired
    private DrugService drugService;

    @GetMapping("/{pn}/{size}")
    public Msg getDrugWithPage(@PathVariable("pn") int pn, @PathVariable("size") int size, @RequestParam(required = false) String name) {
        PageInfo<DrugDTO> info = drugService.getDrugWithPage(pn, size, name);
        if (info != null) {
            return Msg.success().data("drugPageInfo",info);
        }
        return Msg.fail();
    }
    @RolesAllowed({"1","2"})
    @PostMapping(value = "")
    public Msg saveDrug(@RequestBody DrugVo drugParam) {
        drugParam.setCreatetime(new Date());
        drugParam.setUpdatetime(new Date());
        Msg msg = drugService.saveDrug(drugParam);
        return msg;

    }

    @RolesAllowed({"1"})
    @PutMapping(value = "/{id}")
    public Msg updateDrug(@PathVariable("id") Long id, @RequestBody DrugVo drugParam) {
        return drugService.updateDrug(id,drugParam);

    }

    @RolesAllowed({"1"})
    @DeleteMapping(value = "/{drugId}")
    public Msg deleteDrug(@PathVariable("drugId") Long drugId) {
        return drugService.deleteDrug(drugId);

    }

}
