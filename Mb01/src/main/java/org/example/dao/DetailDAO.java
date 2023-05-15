package org.example.dao;

import org.example.domain.Detail;

public interface DetailDAO {
    int insertDetail(Detail detail);
    Detail queryDetail(int user_id );
}
