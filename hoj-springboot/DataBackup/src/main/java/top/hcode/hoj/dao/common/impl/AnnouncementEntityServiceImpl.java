package top.hcode.hoj.dao.common.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import top.hcode.hoj.pojo.entity.common.Announcement;
import top.hcode.hoj.mapper.AnnouncementMapper;
import top.hcode.hoj.pojo.vo.AnnouncementVO;
import top.hcode.hoj.dao.common.AnnouncementEntityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
    公告服务实现类
 */
@Service
public class AnnouncementEntityServiceImpl extends ServiceImpl<AnnouncementMapper, Announcement> implements AnnouncementEntityService {

    @Autowired
    private AnnouncementMapper announcementMapper;

    @Override
    /**
    IPage<AnnouncementVO>：方法的返回类型。IPage 是一个接口，表示分页结果，
    AnnouncementVO 是分页结果中的数据类型。
    getAnnouncementList：方法名，表示获取公告列表。
    int limit：方法的参数，表示每页显示的公告数量。
    int currentPage：方法的参数，表示当前页码。
    Boolean notAdmin：方法的参数，表示是否是非管理员视角。
     */
    public IPage<AnnouncementVO> getAnnouncementList(int limit, int currentPage, Boolean notAdmin) {
        //新建分页
        Page<AnnouncementVO> page = new Page<>(currentPage, limit);
        return announcementMapper.getAnnouncementList(page,notAdmin);
    }

    @Override
    public IPage<AnnouncementVO> getContestAnnouncement(Long cid, Boolean notAdmin, int limit, int currentPage) {
        Page<AnnouncementVO> page = new Page<>(currentPage, limit);
        return announcementMapper.getContestAnnouncement(page,cid,notAdmin);
    }
}
