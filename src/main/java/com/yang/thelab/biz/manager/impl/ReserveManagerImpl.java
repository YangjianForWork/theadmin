package com.yang.thelab.biz.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.yang.thelab.biz.dto.ReserveDTO;
import com.yang.thelab.biz.manager.ReserveManager;
import com.yang.thelab.common.Paginator;
import com.yang.thelab.common.dal.ReserveDAO;
import com.yang.thelab.common.dataobj.ReserveDO;
import com.yang.thelab.common.enums.LabReserveExecStatus;
import com.yang.thelab.common.requ.ReserveQueryRequ;
import com.yang.thelab.common.utils.CommUtil;
import com.yang.thelab.core.model.ReserveExecModel;
import com.yang.thelab.core.model.ReserveModel;
import com.yang.thelab.core.service.ReserveExecService;
import com.yang.thelab.core.service.ReserveService;

/**
 * 
 * @author YJ.yang
 * @version $Id: ReserveManagerImpl.java, v 0.1 2016年5月3日 下午7:18:44 dev Exp $
 */
public class ReserveManagerImpl implements ReserveManager {

    @Autowired
    private ReserveDAO         reserveDAO;
    @Autowired
    private ReserveService     reserveService;
    @Autowired
    private ReserveExecService reserveExecService;

    public Paginator<ReserveDTO> query(ReserveQueryRequ requ) {
        Paginator<ReserveDO> data = reserveDAO.compQuery(requ);
        Paginator<ReserveDTO> result = new Paginator<ReserveDTO>(data.getItemsPerPage(),
            data.getItems());
        result.setPage(data.getPage());
        List<ReserveDTO> listDTO = new ArrayList<ReserveDTO>();
        for (ReserveDO reserveDO : data.getPdate()) {
            ReserveDTO DTO = new ReserveDTO(reserveDO.get());
            listDTO.add(DTO);
        }
        result.setPdate(listDTO);
        return result;
    }

    public void save(ReserveDTO DTO) {
        ReserveModel model = new ReserveModel(DTO.get());
        boolean insert = CommUtil.isInsert(model);
        reserveService.save(model);
        ReserveExecModel execModel = null;
        if (insert) {
            execModel = new ReserveExecModel();
            execModel.get().setStatus(LabReserveExecStatus.INIT);
            execModel.get().setReserveNO(model.getBizNO());
        }
        reserveExecService.save(execModel);
    }

}
