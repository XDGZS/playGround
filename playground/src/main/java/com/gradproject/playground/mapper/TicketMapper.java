package com.gradproject.playground.mapper;

import com.gradproject.playground.entity.Ticket;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TicketMapper {
    public int addTicket(Ticket ticket);

    public List<Ticket> findAll();

    public List<Ticket> findByUserId(int UserId);

    public List<Ticket> findByScenicId(int ScenicId);

    public int deleteScenic(@Param("Uid") int userId, @Param("Sid") int scenicId);
}
