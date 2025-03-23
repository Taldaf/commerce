package org.taldaf.commerce.core.item.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import org.taldaf.commerce.core.item.model.ItemDto
import org.taldaf.commerce.core.item.model.ItemPostDto
import org.taldaf.commerce.core.item.service.ItemCommandService
import org.taldaf.commerce.core.item.service.ItemQueryService

@Slf4j
@RestController
@RequiredArgsConstructor
@Tag(name = "Item API", description = "상품 관련 API")
class ItemController(
    private val itemQueryService: ItemQueryService,
    private val itemCommandService: ItemCommandService,
) {
    @Operation(
        summary = "상품 등록",
        description = "신규 상품을 등록합니다."
    )
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200", 
                description = "상품 등록 성공", 
                content = [Content(schema = Schema(implementation = ItemDto::class))]
            )
        ]
    )
    @PostMapping("/item")
    fun postItem(
        @Parameter(description = "등록할 상품 정보", required = true) 
        itemPostDto: ItemPostDto
    ): ItemDto {
        return itemCommandService.saveItem(itemPostDto)
    }

    @Operation(
        summary = "상품 목록 조회",
        description = "페이징 처리된 상품 목록을 조회합니다."
    )
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200", 
                description = "상품 목록 조회 성공"
            )
        ]
    )
    @GetMapping("/item")
    fun getItemList(
        @Parameter(description = "페이지 정보 (size: 페이지 크기(최대 100), page: 페이지 번호)")
        @PageableDefault(size = 10, page = 0) pageable: Pageable
    ): List<ItemDto> {
        return itemQueryService.getItemList(pageable)
    }

    @Operation(
        summary = "상품 상세 조회",
        description = "상품 ID로 상품 상세 정보를 조회합니다."
    )
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200", 
                description = "상품 조회 성공", 
                content = [Content(schema = Schema(implementation = ItemDto::class))]
            ),
            ApiResponse(responseCode = "404", description = "상품을 찾을 수 없음")
        ]
    )
    @GetMapping("/item/{itemId}")
    fun getItem(
        @Parameter(description = "조회할 상품 ID", required = true)
        @PathVariable itemId: Long
    ): ItemDto {
        return itemQueryService.getItem(itemId)
    }
}
