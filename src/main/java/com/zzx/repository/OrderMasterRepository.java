package com.zzx.repository;

import com.sun.xml.internal.ws.developer.JAXWSProperties;
import com.zzx.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName OrderMasterRepository
 * @Description
 * @Author zhangzx
 * @Date 2019/7/17 11:41
 * Version 1.0
 **/
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {

    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
