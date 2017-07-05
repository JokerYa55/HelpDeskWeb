/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;

/**
 *
 * @author vasil
 * @param <T> класс с которым работает интерфейс
 * @param <V> Тип уникального ключа
 */
public interface beanDAO<T, V> {
    public T getItem(V id);
    public List<T> getList();
    public List<T> getList(V startIdx, V stopIdx);
    public V addItem(T item);
    public boolean updateItem(T item);
    public boolean deleteItem(T item);
}
