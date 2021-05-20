import request from '@/utils/request'
export function fetchList(params) {
  return request({
    url:'/flashProductRelation/list',
    method:'get',
    params:params
  })
}
export function createFlshProductionRelation(data) {
    return request({
        url: '/flashProductionRelation/create',
        method: 'post',
        data:data
    })
}
export function deleteFlashProductRelation(id) {
  return request({
    url:'/flashProductRelation/delete/'+id,
    method:'post'
  })
}
export function updateFlashProductRelation(id,data) {
  return request({
    url:'/flashProductRelation/update/'+id,
    method:'post',
    data:data
  })
}

