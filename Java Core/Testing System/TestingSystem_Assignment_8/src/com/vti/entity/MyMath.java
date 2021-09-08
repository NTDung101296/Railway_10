package com.vti.entity;

public class MyMath<N extends Number> {

	public <T extends Comparable<T>> T maximum(T x, T y, T z) {
		T max = x;
		if (y.compareTo(max) > 0) {
			max = y;
		}
		if (z.compareTo(max) > 0) {
			max = z;
		}
		return max;
	}

	@SuppressWarnings("unchecked")
	public N add(N... numbers) {
		Double sum = 0D;
		for (N number : numbers) {
			sum += number.doubleValue();
		}
		return (N) sum;
	}

	@SuppressWarnings("unchecked")
	public N substract(N x, N y) {
		Double substract = x.doubleValue() - y.doubleValue();
		return (N) substract;
	}

	@SuppressWarnings("unchecked")
	public N pow(N x, N y) {
		Double pow = Math.pow(x.doubleValue(), y.doubleValue());
		return (N) pow;
	}

}
