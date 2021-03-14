import request from '@/utils/request'

// 查询部门列表
export function listDept(query) {
  return request({
    url: '/tpw/light2/dept/list',
    method: 'get',
    params: query
  })
}
// 查询部门
export function selectDept(id) {
  return request({
    url: `/system/light/dept/${id}`,
    method: 'get',
  })
}

// 修改部门
export function updateDept(data) {
  return request({
    url: `/system/light/dept/`,
    method: 'put',
    data:data,
  })
}
//删除部门
export function deleteDept(id) {
  return request({
    url: `/system/light/dept/${id}`,
    method: 'delete',
  })
}
//新增
export function addDept(data) {
  return request({
    url: `/system/light/dept`,
    method: 'post',
    data:data,
  })
}
