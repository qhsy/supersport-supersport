package com.uhutu.dcom.component.page;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

/**
 * 是一个util方法 目的是把QueryCondition中的数据转换成SpringData可用的形式；
 * 
 * @author pangjh 
 */

public class QueryConditionUtil{
	
	/**
	 * 将QueryConditions转换成SpringData可用的条件
	 * @param <T>
	 */
	public static <T> Specification<T> buildSpecification(QueryConditions condition) {

		if (condition == null) {
			return null;
		}
		final List<Object> propertyNames = condition.getPropertyNames();
		final List<Object> operators = condition.getOperators();
		final List<Object> values = condition.getValues();

		if (propertyNames == null || propertyNames.isEmpty()) {
			return null;
		}
		return new Specification<T>() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				List<Predicate> predicates = new ArrayList<Predicate>();
				for (int i = 0; i < propertyNames.size(); i++) {
					String propertyName = (String)propertyNames.get(i);
					String operator     = (String)operators.get(i);
					Object value        = values.get(i);
					// 这里注意：应该不会存在带“.”的情况：  这是不是用于别名.列名，是实体.属性,因emp实体规范原因暂时用不到
					String[] names = StringUtils.split(propertyName, ".");
					
					if(operator.equals(QueryConditions.EQUAL)) {
						predicates.add(builder.equal(root.get(names[0]), value));
					} 
					else if(operator.equals(QueryConditions.GREATER_EQUAL)) {
						predicates.add(builder.greaterThanOrEqualTo(root.get(names[0]), (Comparable)value));
					}
					else if(operator.equals(QueryConditions.GREATER_THAN)) {
						predicates.add(builder.greaterThan(root.get(names[0]), (Comparable) value));
					}
					else if(operator.equals(QueryConditions.INCLUDE)) { // 注意这里对于LEFT_INCLUDE和RIGHT_INCLUDE的模式，没办法正确获取到！！
						predicates.add(builder.like(root.get(names[0]), "%" + value + "%"));
					}
					else if(operator.equals(QueryConditions.LEFT_INCLUDE)) { // 注意这里对于LEFT_INCLUDE和RIGHT_INCLUDE的模式，没办法正确获取到！！
						predicates.add(builder.like(root.get(names[0]), value + "%"));
					}
					else if(operator.equals(QueryConditions.RIGHT_INCLUDE)) { // 注意这里对于LEFT_INCLUDE和RIGHT_INCLUDE的模式，没办法正确获取到！！
						predicates.add(builder.like(root.get(names[0]), "%" + value));
					}
					else if(operator.equals("like")) {
						predicates.add(builder.like(root.get(names[0]), "%" + value + "%"));
					}
					else if(operator.equals(QueryConditions.ISEMPTY)) {
						predicates.add(builder.isNull(root.get(names[0])));
					}
					else if(operator.equals(QueryConditions.ISNOTEMPTY)) {
						predicates.add(builder.isNotNull(root.get(names[0])));
					}
					else if(operator.equals(QueryConditions.ISNULL)) {
						predicates.add(builder.isNull(root.get(names[0])));
					}
					else if(operator.equals(QueryConditions.ISNOTNULL)) {
						predicates.add(builder.isNotNull(root.get(names[0])));
					}
					else if(operator.equals(QueryConditions.LESS_EQUAL)) {
						predicates.add(builder.lessThanOrEqualTo(root.get(names[0]), (Comparable) value));
					}
					else if(operator.equals(QueryConditions.LESS_THAN)) {
						predicates.add(builder.lessThan(root.get(names[0]), (Comparable) value));
					}
					else if(operator.equals(QueryConditions.NOT_EQUAL)) {
						predicates.add(builder.notEqual(root.get(names[0]), value));
					}
				}
				// 将所有条件用 and 联合起来
				if (predicates.size() > 0) {
					return builder.and(predicates.toArray(new Predicate[predicates.size()]));
				}
				return builder.conjunction();
			}
		};
	}

	


}
