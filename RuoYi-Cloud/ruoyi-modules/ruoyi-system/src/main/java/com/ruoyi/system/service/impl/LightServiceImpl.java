package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.LightDept;
import com.ruoyi.system.mapper.LightDeptMapper;
import com.ruoyi.system.service.LightDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * light部门管理服务实现
 * @author TPW
 */
@Service
public class LightServiceImpl implements LightDeptService {
    @Autowired
    private LightDeptMapper lightDeptMapper;

    /**
     * 部门查询的实现
     * @return 部门列表
     */
    @Override
    public List<LightDept> selectDeptList() {
        return lightDeptMapper.selectDeptList();
    }

    /**
     * 根据id查询
     * @param id 部门id
     * @return 部门信息
     */
    @Override
    public LightDept selectDeptById(Long id){
        return lightDeptMapper.selectDeptById(id);
    }
    /**
     * 修改部门信息
     * @param lightDept 需要修改的部门信息
     * @return 修改之后的部门信息
     */
    @Override
    public int updateDept(LightDept lightDept){
        return lightDeptMapper.updateDept(lightDept);
    }

    @Override
    public int deleteDeptById(Long id) {
        return lightDeptMapper.deleteDeptById(id);
    }

    @Override
    public int insertDept(LightDept lightDept) {
        return lightDeptMapper.insertDept(lightDept);
    }
}
