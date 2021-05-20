import request from '@/utils/request'
export function fetchList(params) {
  return request({
    url:'/coupon/list',
    method:'get',
    params:params
  })
}
export function createCoupon(data) {
    
    return request({
        url: '/coupon/create',
        method: 'post',
        data:data
    })
}

export function getCounpon(id) {
    
    return request({
        url: '/coupon' + id,
        method: 'get',
        
    })
}

export function updateCounpon(id, data) {
    
    return request({

        url: '/counpon/update/' + id,
        method: 'post',
        data:data
    })
}

export function deleteCoupon(id) {
  return request({
    url:'/coupon/delete/'+id,
    method:'post',
  })
}

