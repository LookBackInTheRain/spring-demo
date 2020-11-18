package club.yuit.service;

import java.io.Serializable;

public interface BaseService<T> {

    T getById(Serializable id);

}
