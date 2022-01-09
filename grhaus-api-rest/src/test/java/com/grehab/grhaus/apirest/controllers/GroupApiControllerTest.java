package com.grehab.grhaus.apirest.controllers;

import com.grehab.grhaus.apirest.mappers.RestGroupMapper;
import com.grehab.grhaus.domain.usecases.group.CreateGroupUseCase;
import com.grehab.grhaus.domain.usecases.group.DeleteGroupUseCase;
import com.grehab.grhaus.domain.usecases.group.GetGroupByIdUseCase;
import com.grehab.grhaus.domain.usecases.group.UpdateGroupUseCase;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@RequiredArgsConstructor
public class GroupApiControllerTest {

  @Mock
  private final CreateGroupUseCase createGroupUseCase;

  @Mock
  private final GetGroupByIdUseCase getGroupByIdUseCase;

  @Mock
  private final UpdateGroupUseCase updateGroupUseCase;

  @Mock
  private final DeleteGroupUseCase deleteGroupUseCase;

  @Mock
  private final RestGroupMapper mapper;

  @InjectMocks
  private final GroupApiController controller;

  @Test
  void givenNullId_whenGetGroup_shouldRaiseException() {}

  @Test
  void givenValidId_whenGetGroup_shouldSuccess() {}

  @Test
  void givenNullId_whenDeleteGroup_shouldRaiseException() {}

  @Test
  void givenValidId_whenDeleteGroup_shouldSuccess() {}

  @Test
  void givenNullGroupIn_whenCreateGroup_shouldRaiseException() {}

  @Test
  void givenInvalidGroupIn_whenCreateGroup_shouldRaiseException() {}

  @Test
  void givenValidGroupIn_whenCreateGroup_shouldSuccess() {}

  @Test
  void givenNullGroupIn_whenUpdateGroup_shouldRaiseException() {}

  @Test
  void givenInvalidGroupIn_whenUpdateGroup_shouldRaiseException() {}

  @Test
  void givenValidGroupIn_whenUpdateGroup_shouldSuccess() {}

}
