package com.tpw.dept.service;


import com.tpw.dept.domain.LightDept;

import java.util.List;

/**
 * 部门管理 服务处
 * @author TPW
 */
public interface LightDeptService {
    /**
     * 查询所有部门
     * @return 部门列表
     */
    public List<LightDept> selectDeptList();
    /**
     * 根据id查询
     * @param id 部门id
     * @return 部门信息
     */
    public LightDept selectDeptById(Long id);
    /**
     * 修改部门信息
     * @param lightDept 需要修改的部门信息
     * @return 修改之后的部门信息
     */
    public int updateDept(LightDept lightDept);
    /**
     * 删除部门
     * @param id 删除部门
     * @return 返回删除的条数
     */
    public int deleteDeptById(Long id);

    /**
     * 新增部门
     * @param lightDept
     * @return 插入条数
     */
    public int insertDept(LightDept lightDept);
}
