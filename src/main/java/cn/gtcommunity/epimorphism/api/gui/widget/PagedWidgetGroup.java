package cn.gtcommunity.epimorphism.api.gui.widget;

import com.lowdragmc.lowdraglib.gui.widget.WidgetGroup;
import com.lowdragmc.lowdraglib.utils.Position;
import com.lowdragmc.lowdraglib.utils.Size;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class PagedWidgetGroup extends WidgetGroup {
    @Getter
    private int pageIndex;
    protected List<WidgetGroup> pageList = new ArrayList<>();

    public PagedWidgetGroup() {/**/}

    public PagedWidgetGroup(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public PagedWidgetGroup(Position position) {
        super(position);
    }

    public PagedWidgetGroup(Position position, Size size) {
        super(position, size);
    }

    public PagedWidgetGroup addPage(WidgetGroup widgetGroup) {
        if (widgetGroup != null && !pageList.contains(widgetGroup)) {
            pageList.add(widgetGroup);
            if (pageList.indexOf(widgetGroup) == 0) this.addWidget(widgetGroup);
        }
        return this;
    }

    public void pageUp() {
        removeWidget(pageList.get(pageIndex));
        if (--pageIndex < 0) {
            pageIndex = pageList.size() - 1;
        }
        addWidget(pageList.get(pageIndex));
    }

    public void pageDown() {
        removeWidget(pageList.get(pageIndex));
        if (++pageIndex >= pageList.size()) {
            pageIndex = 0;
        }
        addWidget(pageList.get(pageIndex));
    }
}
