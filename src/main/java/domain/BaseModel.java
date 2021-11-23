package domain;

import java.util.Objects;

//Базовый класс модели имеющий ключ id
public class BaseModel {

    protected long id;

    public BaseModel() {}


    public BaseModel(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BaseModel baseModel = (BaseModel) obj;
        return id == baseModel.id;
    }


}
