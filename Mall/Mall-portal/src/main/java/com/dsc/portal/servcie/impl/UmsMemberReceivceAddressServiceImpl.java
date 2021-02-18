package com.dsc.portal.servcie.impl;

import com.dsc.mall.mapper.UmsMemberReceiveAddressMapper;
import com.dsc.mall.model.UmsMember;
import com.dsc.mall.model.UmsMemberReceiveAddress;
import com.dsc.mall.model.UmsMemberReceiveAddressExample;
import com.dsc.portal.servcie.UmsMemberReceiveAddressService;
import com.dsc.portal.servcie.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author 60221
 * 用户管理Service实实现类
 */
@Service
public class UmsMemberReceivceAddressServiceImpl implements UmsMemberReceiveAddressService {

    @Autowired
    private UmsMemberService memberService;
    @Autowired
    private UmsMemberReceiveAddressMapper addressMapper;


    @Override
    public int add(UmsMemberReceiveAddress address) {

        UmsMember currentMember = memberService.getCurrentMember();
        address.setMemberId(currentMember.getId());
        return addressMapper.insert(address);
    }

    @Override
    public int delete(Long id) {

        UmsMember currentMember = memberService.getCurrentMember();
        UmsMemberReceiveAddressExample example = new UmsMemberReceiveAddressExample();
        example.createCriteria().andMemberIdEqualTo(currentMember.getId()).andIdEqualTo(id);
        return addressMapper.deleteByExample(example);
    }

    @Override
    public int update(Long id, UmsMemberReceiveAddress address) {

        address.setId(null);
        UmsMember currentMember = memberService.getCurrentMember();
        UmsMemberReceiveAddressExample example = new UmsMemberReceiveAddressExample();
        example.createCriteria().andMemberIdEqualTo(currentMember.getId()).andIdEqualTo(id);
        if (address.getDefaultStatus() == 1) {
            //先将原来的默认地址去除
            UmsMemberReceiveAddress record = new UmsMemberReceiveAddress();
            record.setDefaultStatus(0);
            UmsMemberReceiveAddressExample updateExample = new UmsMemberReceiveAddressExample();
            updateExample.createCriteria()
                    .andMemberIdEqualTo(currentMember.getId())
                    .andDefaultStatusEqualTo(1);
            addressMapper.updateByExampleSelective(record, updateExample);
        }
        return addressMapper.updateByExampleSelective(address, example);
    }

    @Override
    public List<UmsMemberReceiveAddress> list() {
        UmsMember currentMember = memberService.getCurrentMember();
        UmsMemberReceiveAddressExample example = new UmsMemberReceiveAddressExample();
        example.createCriteria().andMemberIdEqualTo(currentMember.getId());
        return addressMapper.selectByExample(example);

    }

    @Override
    public UmsMemberReceiveAddress getItem(Long id) {

        UmsMember currentMember = memberService.getCurrentMember();
        UmsMemberReceiveAddressExample example = new UmsMemberReceiveAddressExample();
        example.createCriteria().andMemberIdEqualTo(currentMember.getId()).andIdEqualTo(id);
        List<UmsMemberReceiveAddress> addressList = addressMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(addressList)) {
            return addressList.get(0);
        }
        return null;
    }
}

