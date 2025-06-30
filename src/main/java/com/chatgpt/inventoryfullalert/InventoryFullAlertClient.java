package com.chatgpt.inventoryfullalert;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.sound.SoundCategory;

public class InventoryFullAlertClient implements ClientModInitializer {
    private boolean notified = false;

    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player == null) return;
            ClientPlayerEntity p = client.player;
            boolean allFull = p.getInventory().main.stream()
                .allMatch(s -> !s.isEmpty() && s.getCount() == s.getMaxCount());
            if (allFull && !notified) {
                client.world.playSound(p, p.getBlockPos(), SoundEvents.BLOCK_NOTE_BLOCK_PLING, SoundCategory.PLAYERS, 1f, 1f);
                notified = true;
            }
            if (!allFull) notified = false;
        });
    }
}
