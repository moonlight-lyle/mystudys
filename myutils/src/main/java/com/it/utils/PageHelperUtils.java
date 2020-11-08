package com.it.utils;

import java.util.List;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author
 * @ClassName:
 * @Description: 基于com.github.pagehelper分页插件的手动分页
 * @date 2020年3月15日
 */
public class PageHelperUtils {

    /**
     * @param pageNum  当前页
     * @param pageSize 每页显示的数目
     * @param list     逻辑处理之后所需要统计的总数据
     * @return PageInfo<T> 返回PageInfo，这是统计数据中当前页需要显示的数据集合（分页数据）
     * @Title: initPageInfo
     * @Description: 将整理后需要分页的数据list进行分页显示
     */
    public static <T> PageInfo<T> initPageInfo(int pageNum, int pageSize, List<T> list) {
        int total = list.size();
        // 默认如果当前页小于0则为第一页
        pageNum = pageNum <= 0 ? 1 : pageNum;
        // 默认如果当前页大于最大的页数为当前页
        pageNum = pageNum > (total + pageSize - 1) / pageSize ? (total + pageSize - 1) / pageSize : pageNum;
        // 将需要分页的数组进行截取处理
        int fromIndex = 0;
        int toIndex = 0;
        if (total / pageSize == 0 && total % pageSize > 0) {
            // 表示当前数据只有一页
            fromIndex = 0;
            toIndex = total;
        } else if (total / pageSize >= 1 && total % pageSize >= 0) {
            // 超过一页
            fromIndex = (pageNum - 1) * pageSize;
            toIndex = pageNum * pageSize >= total ? total : pageSize * pageNum;
        }
        // 真正需要分页显示的数据
        List<T> tempList = list.subList(fromIndex, toIndex);
        // 结果集(每页显示的数据)
        PageInfo<T> pageInfo = new PageInfo<>(tempList);
        // 当前页
        pageInfo.setPageNum(pageNum);
        // 每页的数量
        pageInfo.setPageSize(pageSize);
        // 当前页的数量
        pageInfo.setSize(tempList.size());
        // 当前页面第一个元素在数据库中的行号
        pageInfo.setStartRow(0);
        // 当前页面最后一个元素在数据库中的行号
        pageInfo.setEndRow(tempList.size() > 0 ? tempList.size() - 1 : 0);
        // 总记录数
        pageInfo.setTotal(total);
        // 总页数
        pageInfo.setPages((total + pageSize - 1) / pageSize);
        // 计算导航页
        calcNavigatepageNums(pageInfo);
        // 计算前后页，第一页，最后一页
        calcPage(pageInfo);
        // 判断页面边界
        judgePageBoudary(pageInfo);
        return pageInfo;
    }

    /**
     * 计算导航页
     */
    private static <T> void calcNavigatepageNums(PageInfo<T> pageInfo) {
        int pages = pageInfo.getPages();
        int navigatePages = pageInfo.getNavigatePages();
        int pageNum = pageInfo.getPageNum();
        // 当总页数小于或等于导航页码数时
        if (pages <= navigatePages) {
            pageInfo.setNavigatepageNums(new int[pages]);
            for (int i = 0; i < pages; i++) {
                pageInfo.getNavigatepageNums()[i] = i + 1;
            }
        } else { // 当总页数大于导航页码数时
            pageInfo.setNavigatepageNums(new int[navigatePages]);
            int startNum = pageNum - navigatePages / 2;
            int endNum = pageNum + navigatePages / 2;

            if (startNum < 1) {
                startNum = 1;
                // (最前navigatePages页
                for (int i = 0; i < navigatePages; i++) {
                    pageInfo.getNavigatepageNums()[i] = startNum++;
                }
            } else if (endNum > pages) {
                endNum = pages;
                // 最后navigatePages页
                for (int i = navigatePages - 1; i >= 0; i--) {
                    pageInfo.getNavigatepageNums()[i] = endNum--;
                }
            } else {
                // 所有中间页
                for (int i = 0; i < navigatePages; i++) {
                    pageInfo.getNavigatepageNums()[i] = startNum++;
                }
            }
        }
    }

    /**
     * 计算前后页，第一页，最后一页
     */
    private static <T> void calcPage(PageInfo<T> pageInfo) {
        int[] navigatepageNums = pageInfo.getNavigatepageNums();
        int pageNum = pageInfo.getPageNum();
        int pages = pageInfo.getPages();
        if (navigatepageNums != null && navigatepageNums.length > 0) {
            pageInfo.setFirstPage(navigatepageNums[0]);
            pageInfo.setLastPage(navigatepageNums[navigatepageNums.length - 1]);
            if (pageNum > 1) {
                pageInfo.setPrePage(pageNum - 1);
            }
            if (pageNum < pages) {
                pageInfo.setNextPage(pageNum + 1);
            }
        }
    }

    /**
     * 判定页面边界
     */
    private static <T> void judgePageBoudary(PageInfo<T> pageInfo) {
        int pageNum = pageInfo.getPageNum();
        int pages = pageInfo.getPages();
        pageInfo.setIsFirstPage(pageNum == 1);
        pageInfo.setIsLastPage(pageNum == pages);
        pageInfo.setHasPreviousPage(pageNum > 1);
        pageInfo.setHasNextPage(pageNum < pages);
    }

}