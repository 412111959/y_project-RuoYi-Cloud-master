package com.ruoyi.system.controller;

import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.system.domain.LightDept;
import com.ruoyi.system.service.LightDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门信息controller
 * @author TPW
 */
@RestController
@RequestMapping("/light/dept")
public class LightDeptController {
    @Autowired
    private LightDeptService lightDeptService;
    /**
     * 查询所有controller
     * @return AjaxResult返回结果
     */
    @GetMapping("list")
    public AjaxResult list(){
        List<LightDept> list = lightDeptService.selectDeptList();
        System.out.println(list);
        return AjaxResult.success(list);
    }

    /**
     * 根据ID查询部门
     * @param deptId 部门id
     * @return 返回部门的信息
     */
    @GetMapping("/{deptId}")
    public AjaxResult dept(@PathVariable Long deptId){
        System.out.println("---find-dept-id---"+deptId);
        LightDept dept = lightDeptService.selectDeptById(deptId);
        System.out.println(dept);
        return AjaxResult.success(dept);
    }

    /**
     * 修改部门信息
     * @param lightDept 需要修改的部门信息
     * @return 修改部门成功的信息，没有做修改失败
     */
    @PutMapping
    public AjaxResult edit(@RequestBody LightDept lightDept){
        int i = lightDeptService.updateDept(lightDept);
        return AjaxResult.success("成功修改了"+i+"个部门");
    }

    /**
     * 根据id删除部门
     * @param id 删除部门的id
     * @return 修改部门成功的信息，没有做修改失败
     */
    @DeleteMapping("/{id}")
    public AjaxResult delete(@PathVariable Long id){
        int i = lightDeptService.deleteDeptById(id);
        return AjaxResult.success("成功删除了"+i+"个部门");
    }

    /**
     * 新增部门
     * @param lightDept
     * @return
     */
    @PostMapping()
    public AjaxResult add(@RequestBody LightDept lightDept){
        int i = lightDeptService.insertDept(lightDept);
        return AjaxResult.success("成功新增了"+i+"个部门");
    }
}
