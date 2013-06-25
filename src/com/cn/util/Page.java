package com.cn.util;

public class Page {
	/**
	 * �ܼ�¼��
	 */
	private int totalRow;

	/**
	 * ÿҳ��¼��
	 */
	private int pageSize = 10;

	/**
	 * ��ǰҳ��
	 */
	private int currentCount;

	/**
	 * ��ҳ��
	 */
	private int total;

	/**
	 * ��ʼ��¼�±�
	 */
	private int beginIndex;

	/**
	 * ��ֹ��¼�±�
	 */
	private int endIndex;

	/**
	 * ���췽����ʹ���ܼ�¼������ǰҳ��
	 * 
	 * @param totalRow
	 *            �ܼ�¼��
	 * @param currentCount
	 *            ��ǰҳ�棬��1��ʼ
	 */
	public Page(int totalRow, int currentCount) {
		this.totalRow = totalRow;
		this.currentCount = currentCount;
		System.out.println(totalRow+">>>>>>"+currentCount);
		calculate();
	}

	/**
	 * ���췽�� �������ܼ�¼������ǰҳ��
	 * 
	 * @param totalRow
	 *            �ܼ�¼��
	 * @param currentCount
	 *            ��ǰҳ��
	 * @param pageSize
	 *            Ĭ��10��
	 */
	public Page(int totalRow, int currentCount, int pageSize) {
		this.totalRow = totalRow;
		this.currentCount = currentCount;
		this.pageSize = pageSize;
		System.out.println(totalRow+"/////"+currentCount+"//////"+pageSize);
		calculate();
	}
   /**
    * ������ҳ������ʼҳ�ͽ���ҳ
    */
	private void calculate() {
		total = totalRow / pageSize + ((totalRow % pageSize) > 0 ? 1 : 0);

		if (currentCount > total) {
			currentCount = total;
		} else if (currentCount < 1) {
			currentCount = 1;
		}

		beginIndex = (currentCount - 1) * pageSize;
		endIndex = beginIndex + pageSize;
		if (endIndex > totalRow) {
			endIndex = totalRow;
		}
	}

	public int getTotalRow() {
		return totalRow;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getCurrentCount() {
		return currentCount;
	}

	public int getTotal() {
		return total;
	}

	public int getBeginIndex() {
		return beginIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}


}
