package com.mycompany.sort.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.ComparatorUtils;
import org.apache.commons.collections.comparators.ComparableComparator;
import org.apache.commons.collections.comparators.ComparatorChain;

public class SortHelper {

    /**
     * (根据项目名称)voList排序
     * 
     * @param voList
     */
    @SuppressWarnings("unchecked")
    public static void sortRelationProjVersVOList(List<RelationProjVersVO> voList) {
        if (voList == null || voList.size() < 1) {
            return;
        }

        Comparator mycmp = ComparableComparator.getInstance();
        mycmp = ComparatorUtils.nullLowComparator(mycmp); // 允许null
        // mycmp = ComparatorUtils.reversedComparator(mycmp); //逆序
        
        Comparator secondCmp = ComparableComparator.getInstance();
        secondCmp = ComparatorUtils.nullLowComparator(secondCmp);
        
        ArrayList<Object> sortFields = new ArrayList<Object>();
        sortFields.add(new BeanComparator("projectName", mycmp)); // projectName正序
        sortFields.add(new BeanComparator("projectVersion", secondCmp)); // projectVersion 正序
        ComparatorChain multiSort = new ComparatorChain(sortFields);
        Collections.sort(voList, multiSort);
    }

  
}
