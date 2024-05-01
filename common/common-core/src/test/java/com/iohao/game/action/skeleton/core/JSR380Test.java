/*
 * ioGame
 * Copyright (C) 2021 - present  渔民小镇 （262610965@qq.com、luoyizhu@gmail.com） . All Rights Reserved.
 * # iohao.com . 渔民小镇
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.iohao.game.action.skeleton.core;

import com.iohao.game.action.skeleton.core.action.ExampleActionCmd;
import com.iohao.game.action.skeleton.core.action.pojo.DogValid;
import com.iohao.game.action.skeleton.core.data.TestDataKit;
import com.iohao.game.action.skeleton.core.flow.FlowContext;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author 渔民小镇
 * @date 2022-07-09
 */
@Slf4j
public class JSR380Test {

    BarSkeleton barSkeleton;

    @Before
    public void setUp() {
        BarSkeletonBuilder builder = TestDataKit.createBuilder();
        builder.getSetting().setValidator(true);

        barSkeleton = builder.build();
    }

    @Test
    public void jsr380() {
        DogValid dogValid = new DogValid();

        CmdInfo cmdInfo = CmdInfo.of(ExampleActionCmd.BeeActionCmd.cmd, ExampleActionCmd.BeeActionCmd.jsr380);

        FlowContext flowContext = TestDataKit.ofFlowContext(cmdInfo, dogValid);

        barSkeleton.handle(flowContext);

        Assert.assertTrue(flowContext.getResponse().hasError());
    }
}
