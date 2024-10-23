package com.lssl.medical.controller;

import com.github.pagehelper.PageInfo;
import com.lssl.medical.bean.Msg;
import com.lssl.medical.entity.Sale;
import com.lssl.medical.service.SaleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

/**
 * @author : 黑渊白花
 * @ClassName SaleController
 * @date : 2024/10/23 19:03
 * @Description
 */
@Api(tags = "药店信息控制器")
@RestController
@RequestMapping("/api/sales")
@CrossOrigin
public class SaleController {
    @Autowired
    private SaleService saleService;
    @GetMapping(value = {"/{pn}/{size}",""})
    public Msg getSaleWithPage(@PathVariable(value = "pn",required = false) Integer pn,
                               @PathVariable(value = "size",required = false) Integer size,
                               @RequestParam(required = false) String name) {
        PageInfo<Sale> info = saleService.getSaleWithPage(pn, size, name);
        if (info != null) {
            return Msg.success().data("salePageInfo",info);
        }
        return Msg.fail();
    }

    @GetMapping("{id}")
    public Msg getSaleById(@PathVariable("id") Integer id) {
        Msg msg = saleService.getSaleById(id);
        return msg;
    }

    @RolesAllowed({"1"})
    @PostMapping(value = "")
    public Msg saveSale(@RequestBody Sale sale) {
        String name = sale.getSaleName();
        String phone = sale.getSalePhone();
        boolean leaf = (name == null || phone == null || name == "" || phone == "");
        if (leaf) {
            return Msg.fail().mess("填写信息不完整");
        }
        return saleService.saveSale(sale);

    }

    @RolesAllowed({"1"})
    @PutMapping(value = "/{id}")
    public Msg updateSaleById(@PathVariable("id")Long id, @RequestBody Sale sale) {
        String name = sale.getSaleName();
        String phone = sale.getSalePhone();
        if (name == null || name == "") {
            return Msg.fail().mess("药店名称不能为空");
        }
        if (phone == null || phone == "") {
            return Msg.fail().mess("药店电话不能为空");
        }
        Msg msg = saleService.updateSaleById(id, sale);
        return msg;

    }

    @RolesAllowed({"1"})
    @DeleteMapping("{id}")
    public Msg deleteSaleById(@PathVariable("id") Integer id) {
        Msg msg = saleService.deleteSaleById(id);
        return msg;

    }



}
