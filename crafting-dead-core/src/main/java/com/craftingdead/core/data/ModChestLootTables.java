/**
 * Crafting Dead
 * Copyright (C) 2020  Nexus Node
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.craftingdead.core.data;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import com.craftingdead.core.item.ModItems;
import com.craftingdead.core.world.storage.loot.ModLootTables;
import net.minecraft.loot.BinomialRange;
import net.minecraft.loot.ConstantRange;
import net.minecraft.loot.ItemLootEntry;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.functions.SetCount;
import net.minecraft.util.ResourceLocation;

public class ModChestLootTables
    implements Consumer<BiConsumer<ResourceLocation, LootTable.Builder>> {

  @Override
  public void accept(BiConsumer<ResourceLocation, LootTable.Builder> t) {
    t.accept(ModLootTables.MEDICAL_SUPPLY_DROP, new LootTable.Builder()
        .addLootPool(LootPool.builder()
            .rolls(ConstantRange.of(10))
            .addEntry(ItemLootEntry.builder(ModItems.BANDAGE.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(4, 0.5F))))
            .addEntry(ItemLootEntry.builder(ModItems.CLEAN_RAG.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(4, 0.5F))))
            .addEntry(ItemLootEntry.builder(ModItems.FIRST_AID_KIT.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(6, 0.12F))))
            .addEntry(ItemLootEntry.builder(ModItems.ADRENALINE_SYRINGE.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(4, 0.5F))))
            .addEntry(ItemLootEntry.builder(ModItems.CURE_SYRINGE.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(4, 0.5F))))
            .addEntry(ItemLootEntry.builder(ModItems.RBI_SYRINGE.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(3, 0.5F))))
            .addEntry(ItemLootEntry.builder(ModItems.SPLINT.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(4, 0.5F))))
            .addEntry(ItemLootEntry.builder(ModItems.ARMY_MEDIC_CLOTHING.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(2, 0.5F))))
            .addEntry(ItemLootEntry.builder(ModItems.M9_MAGAZINE.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(3, 0.5F))))
            .addEntry(ItemLootEntry.builder(ModItems.M1911_MAGAZINE.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(3, 0.5F))))
            .addEntry(ItemLootEntry.builder(ModItems.G18_MAGAZINE.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(3, 0.5F))))
            .addEntry(ItemLootEntry.builder(ModItems.PIPE_GRENADE.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(3, 0.5F))))
            .addEntry(ItemLootEntry.builder(ModItems.SMOKE_GRENADE.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(3, 0.5F))))
            .addEntry(ItemLootEntry.builder(ModItems.ADRENALINE_SYRINGE.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(2, 0.5F))))
            .addEntry(ItemLootEntry.builder(ModItems.M1911.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(4, 0.4F))))
            .addEntry(ItemLootEntry.builder(ModItems.G18.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(2, 0.3F))))
            .addEntry(ItemLootEntry.builder(ModItems.M9.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(2, 0.3F))))
            .addEntry(ItemLootEntry.builder(ModItems.AK47_30_ROUND_MAGAZINE.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(2, 0.45F))))));

    t.accept(ModLootTables.MILITARY_SUPPLY_DROP, new LootTable.Builder()
        .addLootPool(LootPool.builder()
            .rolls(ConstantRange.of(10))
            .addEntry(ItemLootEntry.builder(ModItems.BANDAGE.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(4, 0.5F))))
            .addEntry(ItemLootEntry.builder(ModItems.BOLT_CUTTERS.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(2, 0.7F))))
            .addEntry(ItemLootEntry.builder(ModItems.C4.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(6, 0.2F))))
            .addEntry(ItemLootEntry.builder(ModItems.REMOTE_DETONATOR.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(1, 0.9F))))
            .addEntry(ItemLootEntry.builder(ModItems.STANAG_30_ROUND_MAGAZINE.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(5, 0.5F))))
            .addEntry(ItemLootEntry.builder(ModItems.M107_MAGAZINE.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(6, 0.4F))))
            .addEntry(ItemLootEntry.builder(ModItems.M9_MAGAZINE.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(5, 0.5F))))
            .addEntry(ItemLootEntry.builder(ModItems.G18_MAGAZINE.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(5, 0.5F))))
            .addEntry(ItemLootEntry.builder(ModItems.M240B_MAGAZINE.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(2, 0.4F))))
            .addEntry(ItemLootEntry.builder(ModItems.RPK_DRUM_MAGAZINE.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(2, 0.4F))))
            .addEntry(ItemLootEntry.builder(ModItems.MINIGUN_MAGAZINE.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(2, 0.6F))))
            .addEntry(ItemLootEntry.builder(ModItems.MPT55_MAGAZINE.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(3, 0.5F))))
            .addEntry(ItemLootEntry.builder(ModItems.FRAG_GRENADE.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(3, 0.5F))))
            .addEntry(ItemLootEntry.builder(ModItems.FIRE_GRENADE.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(3, 0.5F))))
            .addEntry(ItemLootEntry.builder(ModItems.FLASH_GRENADE.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(2, 0.5F))))
            .addEntry(ItemLootEntry.builder(ModItems.ACOG_SIGHT.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(4, 0.4F))))
            .addEntry(ItemLootEntry.builder(ModItems.SUPPRESSOR.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(3, 0.3F))))
            .addEntry(ItemLootEntry.builder(ModItems.HP_SCOPE.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(3, 0.2F))))
            .addEntry(ItemLootEntry.builder(ModItems.ARMY_CLOTHING.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(3, 0.4F))))
            .addEntry(ItemLootEntry.builder(ModItems.TAC_GHILLIE_CLOTHING.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(4, 0.3F))))
            .addEntry(ItemLootEntry.builder(ModItems.SPACE_SUIT_CLOTHING.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(3, 0.2F))))
            .addEntry(ItemLootEntry.builder(ModItems.JUGGERNAUT_CLOTHING.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(2, 0.8F))))
            .addEntry(ItemLootEntry.builder(ModItems.COMBAT_BDU_CLOTHING.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(2, 0.8F))))
            .addEntry(ItemLootEntry.builder(ModItems.CLONE_CLOTHING.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(1, 0.6F))))
            .addEntry(ItemLootEntry.builder(ModItems.CONTRACTOR_CLOTHING.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(2, 0.5F))))
            .addEntry(ItemLootEntry.builder(ModItems.AK47.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(3, 0.45F))))
            .addEntry(ItemLootEntry.builder(ModItems.M4A1.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(3, 0.5F))))
            .addEntry(ItemLootEntry.builder(ModItems.M107.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(3, 0.2F))))
            .addEntry(ItemLootEntry.builder(ModItems.M1911.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(6, 0.4F))))
            .addEntry(ItemLootEntry.builder(ModItems.G18.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(5, 0.3F))))
            .addEntry(ItemLootEntry.builder(ModItems.M9.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(5, 0.3F))))
            .addEntry(ItemLootEntry.builder(ModItems.P250.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(5, 0.5F))))
            .addEntry(ItemLootEntry.builder(ModItems.AS50.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(1, 0.7F))))
            .addEntry(ItemLootEntry.builder(ModItems.M240B.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(1, 0.9F))))
            .addEntry(ItemLootEntry.builder(ModItems.MINIGUN.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(1, 0.2F))))
            .addEntry(ItemLootEntry.builder(ModItems.MP5A5.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(3, 0.5F))))
            .addEntry(ItemLootEntry.builder(ModItems.MPT55.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(2, 0.3F))))
            .addEntry(ItemLootEntry.builder(ModItems.FURY_PAINT.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(2, 0.5F))))
            .addEntry(ItemLootEntry.builder(ModItems.SCORCHED_PAINT.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(2, 0.4F))))
            .addEntry(ItemLootEntry.builder(ModItems.INFERNO_PAINT.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(2, 0.4F))))
            .addEntry(ItemLootEntry.builder(ModItems.AK47_30_ROUND_MAGAZINE.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(2, 0.45F))))
            .addEntry(ItemLootEntry.builder(ModItems.MOSSBERG.get())
                .acceptFunction(SetCount.builder(BinomialRange.of(1, 0.45F))))));
  }
}
