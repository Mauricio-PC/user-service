package com.mauricio.pc.user_service.service;

import com.mauricio.pc.user_service.dto.CreateUserRequest;
import com.mauricio.pc.user_service.dto.UpdateUserRequest;
import com.mauricio.pc.user_service.dto.UserDTO;
import com.mauricio.pc.user_service.entity.User;
import com.mauricio.pc.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDTO getByUsername(String username) {
        Optional<User> userOpt = userRepository.findByUsername(username);
        return userOpt.map(this::toDTO).orElse(null);
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public UserDTO createUser(CreateUserRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .avatarUrl(request.getAvatarUrl())
                .role(request.getRole())
                .build();
        return toDTO(userRepository.save(user));
    }

    public UserDTO updateUser(Long id, UpdateUserRequest request) {
        Optional<User> userOpt = userRepository.findById(id);
        if (userOpt.isEmpty()) return null;

        User user = userOpt.get();
        user.setEmail(request.getEmail());
        user.setAvatarUrl(request.getAvatarUrl());
        user.setRole(request.getRole());

        return toDTO(userRepository.save(user));
    }

    public boolean deleteUser(Long id) {
        if (!userRepository.existsById(id)) return false;
        userRepository.deleteById(id);
        return true;
    }

    private UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
        BeanUtils.copyProperties(user, dto);
        return dto;
    }
}
